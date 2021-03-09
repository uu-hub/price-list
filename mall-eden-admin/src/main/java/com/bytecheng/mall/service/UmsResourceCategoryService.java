package com.bytecheng.mall.service;

import com.bytecheng.mall.model.UmsResourceCategory;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 20:06
 */
public interface UmsResourceCategoryService {

    /**
     * 获取所有资源分类
     */
    List<UmsResourceCategory> listAll();

    /**
     * 创建资源分类
     */
    int create(UmsResourceCategory umsResourceCategory);

    /**
     * 修改资源分类
     */
    int update(Long id, UmsResourceCategory umsResourceCategory);

    /**
     * 删除资源分类
     */
    int delete(Long id);
}
