package com.bytecheng.mall.service;

import com.bytecheng.mall.dto.PmsProductAttributeCategoryItem;
import com.bytecheng.mall.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 19:58
 */
public interface PmsProductAttributeCategoryService {
    /**
     * 创建属性分类
     */
    int create(String name);

    /**
     * 修改属性分类
     */
    int update(Long id, String name);

    /**
     * 删除属性分类
     */
    int delete(Long id);

    /**
     * 获取属性分类详情
     */
    PmsProductAttributeCategory getItem(Long id);

    /**
     * 分页查询属性分类
     */
    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);

    /**
     * 获取包含属性的属性分类
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}

