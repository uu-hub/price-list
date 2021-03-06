package com.bytecheng.mall.dao;

import com.bytecheng.mall.model.PmsProductAttributeValue;
import feign.Param;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 17:21
 */
public interface PmsProductAttributeValueDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PmsProductAttributeValue> productAttributeValueList);
}
