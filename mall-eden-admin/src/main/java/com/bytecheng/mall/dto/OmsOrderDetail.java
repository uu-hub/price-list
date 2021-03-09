package com.bytecheng.mall.dto;

import com.bytecheng.mall.model.OmsOrder;
import com.bytecheng.mall.model.OmsOrderItem;
import com.bytecheng.mall.model.OmsOrderOperateHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 14:37
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    @ApiModelProperty("订单商品列表")
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    @ApiModelProperty("订单操作记录列表")
    private List<OmsOrderOperateHistory> historyList;
}
