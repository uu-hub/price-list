package io.zbc.price.dao;

import io.zbc.price.entity.GoodsInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IGoodsInfoDao {

    @Select("SELECT * FROM goods_info")
    List<GoodsInfo> selectAllGoodsInfo();

    @Select("SELECT * FROM goods_info WHERE goods_id = #{goodsId}")
    GoodsInfo selectGoodsInfoById(Integer goodsId);

    @Select("SELECT * FROM goods_info WHERE goods_name = #{goodsName}")
    GoodsInfo selectGoodsInfoByName(String goodsName);

    @Insert("")
    Integer insertGoodsInfo(GoodsInfo goodsInfo);

    @Update("")
    int updateGoodsInfo(GoodsInfo goodsInfo);

    @Delete("DELETE FROM GoodsInfo WHERE goods_id = #{goodsId}")
    int deleteGoodsInfoById(Integer goodsId);

    @Select("create TABLE IF NOT EXISTS `goods_info` ( " +
            " `goods_id` integer(4) NOT NULL AUTO_INCREMENT, " +
            " `goods_name` varchar(45) DEFAULT NULL COMMENT '名称', " +
            " `goods_price` double(10,2) DEFAULT NULL COMMENT '价格', " +
            " `quantity` integer(4) DEFAULT NULL COMMENT '数量', " +
            " `unit` varchar(5) DEFAULT NULL COMMENT '单位', " +
            " `spec` varchar(10) DEFAULT NULL COMMENT '规格', " +
            " `type` varchar(5) DEFAULT NULL, " +
            " `supermarket` varchar(20) DEFAULT NULL COMMENT '超市', " +
            " `record_date` date DEFAULT NULL COMMENT '记录日期', " +
            " `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP, " +
            " `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, " +
            " PRIMARY KEY (`goods_id`) " +
            ") ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;")
    void createGoodsInfoTable();

}
