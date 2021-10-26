SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `member_accounts`;
CREATE TABLE `member_accounts`  (
  `id` bigint(20) NOT NULL,
  `account_id` bigint(20) NULL DEFAULT NULL COMMENT '账号',
  `mobile` varchar(20) NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) NULL DEFAULT NULL COMMENT '邮箱',
  `password` varchar(50) NULL DEFAULT NULL COMMENT '登录密码',
  `nick_name` varchar(50) NULL DEFAULT NULL COMMENT '会员昵称',
  `real_name` varchar(50) NULL DEFAULT NULL COMMENT '真实姓名(用户名)',
  `gender` tinyint(4) NULL DEFAULT 3 COMMENT '1男2女3保密',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `card_type` tinyint(4) NULL DEFAULT NULL COMMENT '证件类型（1身份证，2护照）',
  `card_no` varchar(30) NULL DEFAULT NULL COMMENT '证件号',
  `remark` varchar(200) NULL DEFAULT NULL,
  `create_person` varchar(50) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `dr` tinyint(4) NULL DEFAULT 0 COMMENT '0未删除1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `s_member_account_uindex`(`account_id`) USING BTREE,
  INDEX `idx_mobile`(`mobile`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员账号' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `member_delivery_address`;
CREATE TABLE `member_delivery_address`  (
  `id` bigint(20) NOT NULL,
  `account_id` bigint(20) NOT NULL COMMENT '会员账号ID',
  `delivery_mobile` varchar(30) NULL DEFAULT NULL COMMENT '收货人手机号',
  `delivery_phone` varchar(20) NULL DEFAULT NULL COMMENT '收货人座机号',
  `delivery_name` varchar(50) NULL DEFAULT NULL COMMENT '收货人名称',
  `delivery_email` varchar(500) NULL DEFAULT NULL COMMENT '收货人邮箱',
  `postcode` varchar(20) NULL DEFAULT NULL COMMENT '邮编编号',
  `province_code` varchar(50) NULL DEFAULT NULL COMMENT '省编号',
  `city_code` varchar(50) NULL DEFAULT NULL COMMENT '市编号',
  `area_code` varchar(50) NULL DEFAULT NULL COMMENT '区编号',
  `street_code` varchar(50) NULL DEFAULT NULL COMMENT '街道编号',
  `address` varchar(500) NULL DEFAULT NULL COMMENT '详细地址',
  `default_status` tinyint(4) NULL DEFAULT 2 COMMENT '1默认收货地址  2非默认收货地址',
  `create_person` varchar(50) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `dr` tinyint(4) NULL DEFAULT 0 COMMENT '0未删除1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_account_id`(`account_id`) USING BTREE,
  INDEX `idx_delivery_mobile`(`delivery_mobile`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '常用收货地址' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
