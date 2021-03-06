package com.bytecheng.mall.dao;

import com.bytecheng.mall.dto.PmsProductResult;
import feign.Param;

/**
 * @auther zmsoft
 * @Created 2021/3/4 17:38
 */
public interface PmsProductDao {
    /**
     * 获取商品编辑信息
     */
    PmsProductResult getUpdateInfo(@Param("id") Long id);
}