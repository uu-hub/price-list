package com.bytecheng.mall.common.exception;

import com.bytecheng.mall.common.api.IErrorCode;

/**
 * @auther zmsoft
 * @Created 2021/3/3 21:22
 * 断言处理类，用于抛出各种API异常
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
