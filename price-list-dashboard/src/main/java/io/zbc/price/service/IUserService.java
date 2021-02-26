package io.zbc.price.service;

import io.zbc.price.entity.User;

public interface IUserService {

    User getUserByNameAndPassword(User user);

}
