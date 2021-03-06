package com.bytecheng.mall.dao;

import com.bytecheng.mall.model.SmsCouponProductCategoryRelation;
import feign.Param;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 17:40
 */
public interface SmsCouponProductCategoryRelationDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<SmsCouponProductCategoryRelation> productCategoryRelationList);
}
