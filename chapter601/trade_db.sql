SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `shopping_cart_item`;
CREATE TABLE `shopping_cart_item`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `account_id` bigint(20) NOT NULL COMMENT '会员ID',
  `shopping_cart_no` varchar(20) NOT NULL COMMENT '购物车编号',
  `item_id` bigint(20) NOT NULL COMMENT '商品ID',
  `item_num` int(11) NOT NULL COMMENT '商品数量',
  `create_person` varchar(50) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `dr` tinyint(4) NULL DEFAULT 0 COMMENT '0未删除1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_account_id`(`account_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '购物车明细' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `shopping_order`;
CREATE TABLE `shopping_order`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `order_no` varchar(32) NOT NULL COMMENT '订单号',
  `account_id` bigint(20) NULL DEFAULT NULL COMMENT '会员ID',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '订单状态：1.待付款，2.已付款，3.发货中，4.已发货，5.已收货，6.完成，7.取消',
  `frozen_status` tinyint(4) NULL DEFAULT 0 COMMENT '冻结状态 1.交易挂起，2.支付中，3.退款中，4退货中，0解冻',
  `total_item_num` int(11) NOT NULL COMMENT '总商品数量',
  `item_amount` decimal(10, 2) NOT NULL COMMENT '商品总金额',
  `activity_discount_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '活动优惠总金额',
  `freight_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '运费金额',
  `pay_method` varchar(10) NULL DEFAULT NULL COMMENT '支付方式',
  `pay_amount` decimal(10, 2) NOT NULL COMMENT '支付金额',
  `visit_reject_reason` varchar(200) NULL DEFAULT NULL COMMENT '支付平台流水号',
  `remark` varchar(255) NULL DEFAULT NULL COMMENT '买家备注',
  `seller_remark` varchar(255) NULL DEFAULT NULL COMMENT '卖家备注',
  `order_time` datetime(0) NULL DEFAULT NULL COMMENT '下单时间',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '付款时间',
  `shipping_time` datetime(0) NULL DEFAULT NULL COMMENT '发货时间',
  `collect_time` datetime(0) NULL DEFAULT NULL COMMENT '收货时间',
  `cancel_time` datetime(0) NULL DEFAULT NULL COMMENT '取消时间',
  `cancel_type` varchar(50) NULL DEFAULT NULL COMMENT '取消类别',
  `cancel_desc` varchar(255) NULL DEFAULT NULL COMMENT '取消说明',
  `create_person` varchar(50) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `dr` tinyint(4) NULL DEFAULT 0 COMMENT '0未删除1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_tr_order_no`(`order_no`) USING BTREE,
  INDEX `idx_tr_member_id`(`account_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '交易订单' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `shopping_order_item`;
CREATE TABLE `shopping_order_item`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `account_id` bigint(20) NULL DEFAULT NULL COMMENT '会员ID',
  `order_id` bigint(20) NOT NULL COMMENT '订单ID',
  `catalog_id` bigint(20) NULL DEFAULT NULL COMMENT '类目ID',
  `item_type` tinyint(4) NULL DEFAULT NULL COMMENT '商品类型',
  `item_code` varchar(32) NULL DEFAULT NULL COMMENT '商品code',
  `item_name` varchar(50) NULL DEFAULT NULL COMMENT '商品名称',
  `item_num` int(11) NOT NULL COMMENT '商品数量',
  `sku_desc` varchar(8192) NULL DEFAULT NULL COMMENT '规格描述',
  `division_cd` tinyint(4) NULL DEFAULT NULL COMMENT '产品类别',
  `item_price` decimal(10, 2) NOT NULL COMMENT '商品单价',
  `item_discounted_price` decimal(10, 2) NOT NULL COMMENT '优惠商品单价',
  `create_person` varchar(50) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `dr` tinyint(4) NULL DEFAULT 0 COMMENT '0未删除1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_account_id`(`account_id`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE,
  INDEX `idx_item_code`(`item_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单明细' ROW_FORMAT = Dynamic;

DROP TABLE IF EXISTS `shopping_order_delivery`;
CREATE TABLE `shopping_order_delivery`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `account_id` bigint(20) NULL DEFAULT NULL COMMENT '会员ID',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单ID',
  `waybill_no` varchar(1024) NULL DEFAULT NULL COMMENT '运单号',
  `logistics_id` bigint(20) NULL DEFAULT NULL COMMENT '物流ID',
  `logistics_company` varchar(50) NULL DEFAULT NULL COMMENT '物流公司',
  `logistics_company_desc` varchar(50) NULL DEFAULT NULL COMMENT '物流公司备注',
  `logistics_cost` decimal(10, 2) NULL DEFAULT NULL COMMENT '物流费用',
  `logistics_bear` tinyint(4) NULL DEFAULT NULL COMMENT '是否承担运费  1是  2否',
  `address_id` bigint(20) NULL DEFAULT NULL COMMENT '会员收货地址ID',
  `delivery_name` varchar(100) NULL DEFAULT NULL COMMENT '收货人名称',
  `address` varchar(500) NULL DEFAULT NULL COMMENT '详细地址全称',
  `delivery_mobile` varchar(50) NULL DEFAULT NULL COMMENT '收货人手机号',
  `delivery_phone` varchar(20) NULL DEFAULT NULL COMMENT '收货人座机号',
  `province_code` varchar(50) NULL DEFAULT NULL COMMENT '省',
  `province_name` varchar(50) NULL DEFAULT NULL COMMENT '省名称',
  `city_code` varchar(50) NULL DEFAULT NULL COMMENT '市',
  `city_name` varchar(50) NULL DEFAULT NULL COMMENT '市名称',
  `area_code` varchar(50) NULL DEFAULT NULL COMMENT '区',
  `area_name` varchar(50) NULL DEFAULT NULL COMMENT '区名称',
  `detailed` varchar(500) NULL DEFAULT NULL COMMENT '详细地址',
  `street_code` varchar(50) NULL DEFAULT NULL COMMENT '街道',
  `street_name` varchar(50) NULL DEFAULT NULL COMMENT '街道名称',
  `postcode` varchar(10) NULL DEFAULT NULL COMMENT '邮编',
  `remark` varchar(255) NULL DEFAULT NULL COMMENT '备注',
  `create_person` varchar(50) NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_person` varchar(50) NULL DEFAULT NULL COMMENT '修改人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `dr` tinyint(4) NULL DEFAULT 0 COMMENT '0未删除1已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE,
  INDEX `idx_account_id`(`account_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单配送' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
