package io.zbc.price.config;

import io.zbc.price.dao.IGoodsInfoDao;
import io.zbc.price.dao.IUserDao;
import io.zbc.price.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Configuration
public class InitializeConfiguration implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(InitializeConfiguration.class);

    @Autowired
    private IGoodsInfoDao goodsInfoDao;

    @Autowired
    private IUserDao userDao;

    @Value("${price-list.auth.user-name:admin}")
    private String userName;

    @Value("${price-list.auth.password:admin}")
    private String password;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        createTables();
        initDefaultAuth();
    }

    private void createTables() {
        goodsInfoDao.createGoodsInfoTable();
        userDao.createUserTable();
    }

    @Transactional
    public void initDefaultAuth() {
        User user = buildDefaultUser();
        User existUser = userDao.selectUserByName(userName);
        if (existUser != null) {
            user.setUserId(existUser.getUserId());
        } else {
            userDao.insertUser(user);
        }
    }

    private User buildDefaultUser() {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        return user;
    }

}
