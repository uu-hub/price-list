package com.bytecheng.mall.service;

import com.bytecheng.mall.dto.OssCallbackResult;
import com.bytecheng.mall.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther zmsoft
 * @Created 2021/3/4 19:58
 */
public interface OssService {
    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();
    /**
     * oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
