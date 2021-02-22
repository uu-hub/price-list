CREATE TABLE `price_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL COMMENT '名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `quantity` int(11) DEFAULT NULL COMMENT '数量',
  `unit` varchar(5) DEFAULT NULL COMMENT '单位',
  `spec` varchar(10) DEFAULT NULL COMMENT '规格',
  `type` varchar(5) DEFAULT NULL,
  `supermarket` varchar(20) DEFAULT NULL COMMENT '超市',
  `record_date` date DEFAULT NULL COMMENT '记录日期',
  `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8mb4
