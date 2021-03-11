package io.zbc.price.controller.oauth;

import io.zbc.price.entity.User;

public interface IOAuthService<T> {

    User oauthLogin(T data);

    boolean signOut();
}
