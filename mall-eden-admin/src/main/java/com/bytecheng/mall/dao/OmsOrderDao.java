package com.bytecheng.mall.dao;

import com.bytecheng.mall.dto.OmsOrderDeliveryParam;
import com.bytecheng.mall.dto.OmsOrderDetail;
import com.bytecheng.mall.dto.OmsOrderQueryParam;
import com.bytecheng.mall.model.OmsOrder;
import feign.Param;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 15:46
 */
public interface OmsOrderDao {
    /**
     * 条件查询订单
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 批量发货
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 获取订单详情
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
}
