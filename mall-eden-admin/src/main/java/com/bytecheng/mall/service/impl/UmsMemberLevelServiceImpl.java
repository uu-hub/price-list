package com.bytecheng.mall.service.impl;

import com.bytecheng.mall.mapper.UmsMemberLevelMapper;
import com.bytecheng.mall.model.UmsMemberLevel;
import com.bytecheng.mall.model.UmsMemberLevelExample;
import com.bytecheng.mall.service.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther zmsoft
 * @Created 2021/3/4 20:19
 */
@Service
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService {
    @Autowired
    private UmsMemberLevelMapper memberLevelMapper;
    @Override
    public List<UmsMemberLevel> list(Integer defaultStatus) {
        UmsMemberLevelExample example = new UmsMemberLevelExample();
        example.createCriteria().andDefaultStatusEqualTo(defaultStatus);
        return memberLevelMapper.selectByExample(example);
    }
}
