package io.zbc.price.controller.oauth;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import io.zbc.price.config.SystemConfig;
import io.zbc.price.entity.User;
import io.zbc.price.util.LinuxInfoUtil;
import io.zbc.price.util.SignUtil;
import io.zbc.price.util.httpclient.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthService implements IOAuthService<String> {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private SystemConfig systemConfig;

    @Override
    public User oauthLogin(String data) {
        // build request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("Code", data);
        requestBody.put("SiteKey", systemConfig.getSiteKey());
        requestBody.put("SiteSecret", systemConfig.getSiteSecret());
        String authorizationServer = systemConfig.getAuthorizationServer();
        String postResponse = null;
        try {
            postResponse = HttpClientUtil.post(authorizationServer + "/api/token", requestBody);
        } catch (IOException e) {
            logger.error("Get auth token failed.", e);
            return null;
        }
        JSONObject response = JSONObject.parseObject(postResponse);
        String token = response.getString("Token");
        JSONObject userInfo = null;
        if (!Strings.isNullOrEmpty(token)) {
            String userInfoStr;
            try {
                userInfoStr = HttpClientUtil.get(authorizationServer + "/api/user?token=" + token);
            } catch (IOException e) {

                return null;
            }
            userInfo = JSONObject.parseObject(userInfoStr);
        }
        if (userInfo == null) {
            return null;
        }
        User user = new User();
        String userName = userInfo.getString("UserName");
        String avatar = userInfo.getJSONObject("DomainUser").getString("Avatar");
        user.setUserName(userName);
        user.setAvatar(avatar);
        return user;
    }

    @Override
    public boolean signOut() {
        String urlTemplate = "%s/api/%s?callback=%s";
        String authorizationServer = systemConfig.getAuthorizationServer();
        String siteKey = systemConfig.getSiteKey();
        String serverAddress = LinuxInfoUtil.getIp() + SignUtil.COLON + systemConfig.getServerPort();
        try {
            HttpClientUtil.get(String.format(urlTemplate, authorizationServer, siteKey, serverAddress));
        } catch (IOException e) {
            logger.error("Auth sign out failed.", e);
        }
        return false;
    }
}
