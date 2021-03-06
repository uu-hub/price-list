package com.bytecheng.mall.service;

import com.bytecheng.mall.model.CmsPrefrenceArea;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 19:55
 */
public interface CmsPrefrenceAreaService {
    /**
     * 获取所有优选专区
     */
    List<CmsPrefrenceArea> listAll();
}
