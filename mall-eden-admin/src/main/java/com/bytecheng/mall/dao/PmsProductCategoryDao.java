package com.bytecheng.mall.dao;

import com.bytecheng.mall.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 17:28
 */
public interface PmsProductCategoryDao {
    /**
     * 获取商品分类及其子分类
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
