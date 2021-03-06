package com.bytecheng.mall.service;

import com.bytecheng.mall.model.UmsAdmin;

/**
 * @auther zmsoft
 * @Created 2021/3/4 20:05
 */
public interface UmsAdminCacheService {
    /**
     * 删除后台用户缓存
     */
    void delAdmin(Long adminId);

    /**
     * 获取缓存后台用户信息
     */
    UmsAdmin getAdmin(Long adminId);

    /**
     * 设置缓存后台用户信息
     */
    void setAdmin(UmsAdmin admin);
}
