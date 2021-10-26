SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `item_catalog`;
CREATE TABLE `item_catalog`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) NULL DEFAULT NULL COMMENT '类目名称',
  `code` varchar(200) NULL DEFAULT NULL COMMENT '类目Code',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '0禁用 1 启用',
  `statement` varchar(500) NULL DEFAULT NULL COMMENT '描述',
  `sort` int(11) NULL DEFAULT NULL COMMENT '序号',
  `level` int(11) NULL DEFAULT NULL COMMENT '层级',
  `redirect_url` varchar(256) NULL DEFAULT NULL COMMENT '跳转URL',
  `create_person` varchar(50) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `dr` tinyint(4) NULL DEFAULT 0 COMMENT '0未删除1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_code`(`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '类目' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `items`;
CREATE TABLE `items`  (
  `id` bigint(20) NOT NULL,
  `item_id` bigint(20) NULL DEFAULT NULL COMMENT '商品id',
  `catalog_id` bigint(20) NULL DEFAULT NULL COMMENT '类目id',
  `code` varchar(32) NULL DEFAULT NULL COMMENT '编码',
  `name` varchar(200) NULL DEFAULT NULL COMMENT '名称',
  `statement` varchar(500) NULL DEFAULT NULL COMMENT '描述',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '0 禁用 1启用',
  `publish_date` datetime(0) NULL DEFAULT NULL COMMENT '上架日期',
  `create_person` varchar(50) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `dr` tinyint(4) NULL DEFAULT 0 COMMENT '0未删除1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_item_id`(`item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `item_price`;
CREATE TABLE `item_price`  (
  `id` bigint(20) NOT NULL,
  `item_id` bigint(20) NOT NULL COMMENT '商品id',
  `sale_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '销售单价',
  `vate` decimal(10, 2) NULL DEFAULT NULL COMMENT '折扣率',
  `create_person` varchar(50) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `dr` tinyint(4) NULL DEFAULT 0 COMMENT '0未删除1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_item_id`(`item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品价格' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
