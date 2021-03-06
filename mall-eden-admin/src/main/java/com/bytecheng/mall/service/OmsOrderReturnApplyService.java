package com.bytecheng.mall.service;

import com.bytecheng.mall.dto.OmsOrderReturnApplyResult;
import com.bytecheng.mall.dto.OmsReturnApplyQueryParam;
import com.bytecheng.mall.dto.OmsUpdateStatusParam;
import com.bytecheng.mall.model.OmsOrderReturnApply;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 19:56
 */
public interface OmsOrderReturnApplyService {
    /**
     * 分页查询申请
     */
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum);

    /**
     * 批量删除申请
     */
    int delete(List<Long> ids);

    /**
     * 修改申请状态
     */
    int updateStatus(Long id, OmsUpdateStatusParam statusParam);

    /**
     * 获取指定申请详情
     */
    OmsOrderReturnApplyResult getItem(Long id);
}

