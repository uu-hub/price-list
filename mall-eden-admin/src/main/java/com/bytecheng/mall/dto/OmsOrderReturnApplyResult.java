package com.bytecheng.mall.dto;

import com.bytecheng.mall.model.OmsCompanyAddress;
import com.bytecheng.mall.model.OmsOrderReturnApply;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @auther zmsoft
 * @Created 2021/3/4 14:39
 */
public class OmsOrderReturnApplyResult extends OmsOrderReturnApply {
    @Getter
    @Setter
    @ApiModelProperty(value = "公司收货地址")
    private OmsCompanyAddress companyAddress;
}
