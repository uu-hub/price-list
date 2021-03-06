package com.bytecheng.mall.dao;

import com.bytecheng.mall.dto.OmsOrderReturnApplyResult;
import com.bytecheng.mall.dto.OmsReturnApplyQueryParam;
import com.bytecheng.mall.model.OmsOrderReturnApply;
import feign.Param;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 17:20
 */
public interface OmsOrderReturnApplyDao {
    /**
     * 查询申请列表
     */
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);

    /**
     * 获取申请详情
     */
    OmsOrderReturnApplyResult getDetail(@Param("id")Long id);
}
