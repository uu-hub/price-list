package com.bytecheng.mall.dao;

import com.bytecheng.mall.dto.SmsCouponParam;
import feign.Param;

/**
 * @auther zmsoft
 * @Created 2021/3/4 17:40
 */
public interface SmsCouponDao {
    /**
     * 获取优惠券详情包括绑定关系
     */
    SmsCouponParam getItem(@Param("id") Long id);
}
