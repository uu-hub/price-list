package com.bytecheng.mall.service;

import com.bytecheng.mall.model.OmsOrderSetting;

/**
 * @auther zmsoft
 * @Created 2021/3/4 19:57
 */
public interface OmsOrderSettingService {
    /**
     * 获取指定订单设置
     */
    OmsOrderSetting getItem(Long id);

    /**
     * 修改指定订单设置
     */
    int update(Long id, OmsOrderSetting orderSetting);
}