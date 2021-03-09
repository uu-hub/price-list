package com.bytecheng.mall.dto;

import com.bytecheng.mall.model.PmsProduct;
import com.bytecheng.mall.model.SmsFlashPromotionProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @auther zmsoft
 * @Created 2021/3/4 15:40
 */
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelation {
    @Getter
    @Setter
    @ApiModelProperty("关联商品")
    private PmsProduct product;
}