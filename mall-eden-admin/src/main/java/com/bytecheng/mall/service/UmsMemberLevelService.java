package com.bytecheng.mall.service;

import com.bytecheng.mall.model.UmsMemberLevel;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 20:05
 */
public interface UmsMemberLevelService {
    /**
     * 获取所有会员登录
     * @param defaultStatus 是否为默认会员
     */
    List<UmsMemberLevel> list(Integer defaultStatus);
}

