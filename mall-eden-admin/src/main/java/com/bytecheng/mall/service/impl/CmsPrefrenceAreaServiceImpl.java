package com.bytecheng.mall.service.impl;

import com.bytecheng.mall.mapper.CmsPrefrenceAreaMapper;
import com.bytecheng.mall.model.CmsPrefrenceArea;
import com.bytecheng.mall.model.CmsPrefrenceAreaExample;
import com.bytecheng.mall.service.CmsPrefrenceAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 20:08
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}