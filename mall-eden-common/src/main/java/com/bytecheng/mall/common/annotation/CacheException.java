package com.bytecheng.mall.common.annotation;

import java.lang.annotation.*;

/**
 * @auther zmsoft
 * @Created 2021/3/3 21:17
 * 自定义注解，有该注解的缓存方法会抛出异常
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
