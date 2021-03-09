package com.bytecheng.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.locks.LockSupport;

/**
 * @auther zmsoft
 * @Created 2021/3/4 15:43
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.bytecheng.mall.mapper","com.macro.mall.dao"})
public class MyBatisConfig {


}
