package io.zbc.price.service;

import io.zbc.price.entity.GoodsInfo;

import java.util.List;

public interface IGoodsInfoService {

    List<GoodsInfo> getAllGoodsInfoList();

    List<GoodsInfo> getGoodsInfoByName(String goodsName);

    boolean addGoodsInfo(GoodsInfo goodsInfo);
}
