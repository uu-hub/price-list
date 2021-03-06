package com.bytecheng.mall.service;

import com.bytecheng.mall.model.SmsCouponHistory;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 20:01
 */
public interface SmsCouponHistoryService {
    /**
     * 分页查询优惠券领取记录
     * @param couponId 优惠券id
     * @param useStatus 使用状态
     * @param orderSn 使用订单号码
     */
    List<SmsCouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum);
}

