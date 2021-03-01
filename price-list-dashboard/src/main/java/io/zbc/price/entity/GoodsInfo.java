package io.zbc.price.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import static io.zbc.price.util.TimeUtil.TIME_FORMATTER;

public class GoodsInfo {

    private Integer goodsId;
    private String goodsName;
    private double goodsPrice;
    private Integer quantity;
    private String unit;
    private String spec;
    private String type;
    private String supermarket;
    private Date recordDate;

    public GoodsInfo() {

    }

    public GoodsInfo(String goodsName, double goodsPrice, Integer quantity, String unit, String spec, String type, String supermarket, Date recordDate) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.quantity = quantity;
        this.unit = unit;
        this.spec = spec;
        this.type = type;
        this.supermarket = supermarket;
        this.recordDate = recordDate;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(String supermarket) {
        this.supermarket = supermarket;
    }

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }
}
