package io.zbc.price.service.impl;

import io.zbc.price.dao.IGoodsInfoDao;
import io.zbc.price.entity.GoodsInfo;
import io.zbc.price.service.IGoodsInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsInfoService implements IGoodsInfoService {

    private static final Logger logger = LoggerFactory.getLogger(GoodsInfoService.class);

    @Autowired
    IGoodsInfoDao goodsInfoDao;

    @Override
    public List<GoodsInfo> getAllGoodsInfoList() {
        return goodsInfoDao.selectAllGoodsInfo();
    }

    @Override
    public boolean addGoodsInfo(GoodsInfo goodsInfo) {
        try {
            return goodsInfoDao.insertGoodsInfo(goodsInfo) > 0;
        } catch (Exception e) {
            logger.error("Add goods info failed, " + goodsInfo, e);
            return false;
        }
    }

}
