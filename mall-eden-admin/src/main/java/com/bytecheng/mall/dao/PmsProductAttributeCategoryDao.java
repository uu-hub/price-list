package com.bytecheng.mall.dao;

import com.bytecheng.mall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 17:21
 */
public interface PmsProductAttributeCategoryDao {
    /**
     * 获取包含属性的商品属性分类
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}

