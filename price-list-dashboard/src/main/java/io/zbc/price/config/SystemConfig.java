package io.zbc.price.config;

import com.google.common.base.Strings;
import io.zbc.price.exception.ConfigurationException;
import io.zbc.price.util.SignUtil;
import io.zbc.price.util.TimeUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.unit.DataSize;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;
import java.io.File;

@Configuration
public class SystemConfig implements WebMvcConfigurer {

    public static final String AVATAR_PATH = "/data/avatar/";

    @Value("${server.port}")
    private int serverPort;

    @Value("${price-list.auth.avatar-path}")
    private String avatarPath;

    @Value("${price-list.auth.authorization.enabled:false}")
    private boolean authorizationEnabled;

    @Value("${price-list.auth.authorization.server}")
    private String authorizationServer;

    @Value("${price-list.auth.authorization.site-key}")
    private String siteKey;

    @Value("${price-list.auth.authorization.site-secret}")
    private String siteSecret;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (Strings.isNullOrEmpty(avatarPath)) {
            throw new ConfigurationException("avatar-path is empty.");
        }
        File file3 = new File(avatarPath);
        if (!file3.exists()) {
            file3.mkdirs();
        }
        avatarPath += avatarPath.endsWith(SignUtil.SLASH) ? "" : SignUtil.SLASH;
        registry.addResourceHandler(AVATAR_PATH + "**").addResourceLocations("file:" + avatarPath);
    }

    @Override
    public void configureAsyncSupport(final AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(TimeUtil.FIVE_MINUTES);
        configurer.registerCallableInterceptors(timeoutInterceptor());
    }

    @Bean
    public TimeoutCallableProcessingInterceptor timeoutInterceptor() {
        return new TimeoutCallableProcessingInterceptor();
    }

    @Bean
    public RestTemplate buildRestTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(10000);
        factory.setConnectTimeout(15000);
        return new RestTemplate(factory);
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        factory.setMaxFileSize(DataSize.ofBytes(10485760));
        //设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.ofBytes(10485760));
        return factory.createMultipartConfig();
    }

    /**
     * for vue history mode
     *
     * @return
     */
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/index"));
        return factory;
    }

    public int getServerPort() {
        return serverPort;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public boolean getAuthorizationEnabled() {
        return authorizationEnabled;
    }

    public String getAuthorizationServer() {
        return authorizationServer;
    }

    public String getSiteKey() {
        return siteKey;
    }

    public String getSiteSecret() {
        return siteSecret;
    }

}
