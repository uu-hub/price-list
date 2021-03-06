package com.bytecheng.mall.service;

import com.bytecheng.mall.model.OmsCompanyAddress;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 19:56
 */
public interface OmsCompanyAddressService {
    /**
     * 获取全部收货地址
     */
    List<OmsCompanyAddress> list();
}
