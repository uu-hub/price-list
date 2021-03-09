package com.bytecheng.mall.dto;

import com.bytecheng.mall.model.SmsCoupon;
import com.bytecheng.mall.model.SmsCouponProductCategoryRelation;
import com.bytecheng.mall.model.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 15:40
 */
public class SmsCouponParam extends SmsCoupon {
    @Getter
    @Setter
    @ApiModelProperty("优惠券绑定的商品")
    private List<SmsCouponProductRelation> productRelationList;
    @Getter
    @Setter
    @ApiModelProperty("优惠券绑定的商品分类")
    private List<SmsCouponProductCategoryRelation> productCategoryRelationList;
}