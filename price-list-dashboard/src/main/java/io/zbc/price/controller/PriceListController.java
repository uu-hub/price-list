package io.zbc.price.controller;

import io.zbc.price.aop.annotation.OperationLog;

import io.zbc.price.entity.GoodsInfo;
import io.zbc.price.entity.OperationObjectType;
import io.zbc.price.entity.OperationType;
import io.zbc.price.entity.Result;
import io.zbc.price.service.IGoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/list")
@Controller
public class PriceListController {

    @Autowired
    IGoodsInfoService goodsInfoService;

    @RequestMapping(value = "/getAllGoodsInfo/", method = RequestMethod.GET)
    @ResponseBody
    public Result getAllGoodsInfo() {
        List<GoodsInfo> goodsInfoList = goodsInfoService.getAllGoodsInfoList();
        if (goodsInfoList == null || goodsInfoList.isEmpty()) {
            return Result.failResult();
        }
        return Result.successResult(goodsInfoList);
    }

    @RequestMapping(value = "/getGoodsInfoByName", method = RequestMethod.POST)
    @ResponseBody
    public Result getGoodsInfoByName(@RequestBody GoodsInfo goodsInfo) {
        List<GoodsInfo> goodsInfoList = goodsInfoService.getGoodsInfoByName(goodsInfo.getGoodsName());
        if (goodsInfoList == null || goodsInfoList.isEmpty()) {
            return Result.failResult();
        }
        return Result.successResult(goodsInfoList);
    }

    @RequestMapping(value = "/addAlertChannel", method = RequestMethod.POST)
    @ResponseBody
    @OperationLog(type = OperationType.CREATE, objType = OperationObjectType.GOODS_INFO)
    public Result addAlertChannel(@RequestBody GoodsInfo goodsInfo) {
        boolean result = goodsInfoService.addGoodsInfo(goodsInfo);
        return result ? Result.successResult() : Result.failResult();
    }

}
