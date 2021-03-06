package com.bytecheng.mall.service;

import com.bytecheng.mall.model.CmsSubject;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 19:55
 */
public interface CmsSubjectService {
    /**
     * 查询所有专题
     */
    List<CmsSubject> listAll();

    /**
     * 分页查询专题
     */
    List<CmsSubject> list(String keyword, Integer pageNum, Integer pageSize);
}