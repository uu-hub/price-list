package com.bytecheng.mall.service.impl;

import com.bytecheng.mall.mapper.OmsCompanyAddressMapper;
import com.bytecheng.mall.model.OmsCompanyAddress;
import com.bytecheng.mall.model.OmsCompanyAddressExample;
import com.bytecheng.mall.service.OmsCompanyAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 20:08
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;
    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
