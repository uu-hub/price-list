package com.bytecheng.mall.dao;

import com.bytecheng.mall.model.CmsSubjectProductRelation;
import feign.Param;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 15:46
 */
public interface CmsSubjectProductRelationDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<CmsSubjectProductRelation> subjectProductRelationList);
}

