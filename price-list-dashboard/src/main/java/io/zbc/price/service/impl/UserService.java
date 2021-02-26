package io.zbc.price.service.impl;

import io.zbc.price.dao.IUserDao;
import io.zbc.price.entity.User;
import io.zbc.price.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private IUserDao userDao;

    @Override
    public User getUserByNameAndPassword(User user) {
        try {
            User userLogin = userDao.selectUserByNameAndPassword(user);
            if (userLogin == null) {
                return null;
            }
            userLogin.setPassword(null);
            userLogin.setToken(null);
            return userLogin;
        } catch (Exception e) {
            logger.error("Get user by user name and password failed, " + user, e);
            return null;
        }
    }

}
