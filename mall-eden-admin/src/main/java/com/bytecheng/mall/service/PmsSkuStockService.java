package com.bytecheng.mall.service;

import com.bytecheng.mall.model.PmsSkuStock;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 20:00
 */
public interface PmsSkuStockService {
    /**
     * 根据产品id和skuCode模糊搜索
     */
    List<PmsSkuStock> getList(Long pid, String keyword);

    /**
     * 批量更新商品库存信息
     */
    int update(Long pid, List<PmsSkuStock> skuStockList);
}
