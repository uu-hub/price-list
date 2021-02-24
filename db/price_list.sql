create TABLE IF NOT EXISTS `goods_info` (
 `goods_id` integer(4) NOT NULL AUTO_INCREMENT,
 `goods_name` varchar(45) DEFAULT NULL COMMENT '名称',
 `goods_price` double(10,2) DEFAULT NULL COMMENT '价格',
 `quantity` integer(4) DEFAULT NULL COMMENT '数量',
 `unit` varchar(5) DEFAULT NULL COMMENT '单位',
 `spec` varchar(10) DEFAULT NULL COMMENT '规格',
 `type` varchar(5) DEFAULT NULL,
 `supermarket` varchar(20) DEFAULT NULL COMMENT '超市',
 `record_date` date DEFAULT NULL COMMENT '记录日期',
 `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
 `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 PRIMARY KEY (`goods_id`)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;
