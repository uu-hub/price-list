package com.bytecheng.mall.common.api;

/**
 * @auther zmsoft
 * @Created 2021/3/3 21:21
 * 封装API的错误码
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
