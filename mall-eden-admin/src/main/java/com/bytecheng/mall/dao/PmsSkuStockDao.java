package com.bytecheng.mall.dao;

import com.bytecheng.mall.model.PmsSkuStock;
import feign.Param;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 17:40
 */
public interface PmsSkuStockDao {
    /**
     * 批量插入操作
     */
    int insertList(@Param("list") List<PmsSkuStock> skuStockList);

    /**
     * 批量插入或替换操作
     */
    int replaceList(@Param("list")List<PmsSkuStock> skuStockList);
}

