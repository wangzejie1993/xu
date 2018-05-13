/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : temp

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-05-13 22:29:54
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `erp_customer`
-- ----------------------------
DROP TABLE IF EXISTS `erp_customer`;
CREATE TABLE `erp_customer` (
  `id` varchar(32) NOT NULL,
  `name` varchar(250) DEFAULT NULL COMMENT '客户姓名',
  `phone` varchar(11) DEFAULT NULL COMMENT '客户电话',
  `company` varchar(250) DEFAULT NULL COMMENT '客户公司',
  `address` varchar(250) DEFAULT NULL COMMENT '客户公司地址',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `end_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(1) DEFAULT '1' COMMENT '逻辑删除标识 1：有效，0：无效（已删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of erp_customer
-- ----------------------------
INSERT INTO `erp_customer` VALUES ('0392a1906bea47658385665004e16085', '张三', '18112762355', '江苏科技大学', '苏州', '2018-05-01 10:58:16', '2018-05-01 10:58:16', '1');
INSERT INTO `erp_customer` VALUES ('767bc299a1734b6b8b544da43f02090a', '小三', '13567890987', '苏州大学', '苏州市', '2018-03-13 14:41:06', '2018-03-13 14:41:06', '1');

-- ----------------------------
-- Table structure for `erp_customer_order_relationship`
-- ----------------------------
DROP TABLE IF EXISTS `erp_customer_order_relationship`;
CREATE TABLE `erp_customer_order_relationship` (
  `id` varchar(32) NOT NULL,
  `customer_name` varchar(250) DEFAULT NULL COMMENT '客户名称',
  `customer_id` varchar(250) DEFAULT NULL COMMENT '客户id',
  `order_name` varchar(250) DEFAULT NULL COMMENT '订单名称',
  `order_id` varchar(250) DEFAULT NULL COMMENT '订单id',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `end_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(1) DEFAULT '1' COMMENT '逻辑删除标识 1：有效，0：无效（已删除）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `coid` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户，订单，关联表';

-- ----------------------------
-- Records of erp_customer_order_relationship
-- ----------------------------
INSERT INTO `erp_customer_order_relationship` VALUES ('16398d37463e4270affd18c33d496382', '小二', 'd4783d4d3b1c446c8f549e770f8a64cc', '测试订单一号', '4bced8c10f814fcb9fad368f57a07666', '2018-03-13 14:42:21', '2018-03-13 14:42:21', '1');
INSERT INTO `erp_customer_order_relationship` VALUES ('43f6c63256224111a41ea7dc8d65a4b0', '小二', 'd4783d4d3b1c446c8f549e770f8a64cc', '测试2', 'ad6a30aec1804cc1870881fc7b5e381a', '2018-03-13 14:54:45', '2018-03-13 14:54:45', '1');
INSERT INTO `erp_customer_order_relationship` VALUES ('fef8cabea7fe48719bc4b3896c332e1c', '小三', '767bc299a1734b6b8b544da43f02090a', '测试订单1', '215dc4e9fe054dd396d290ada9005e0a', '2018-03-13 21:52:53', '2018-03-13 21:52:53', '1');

-- ----------------------------
-- Table structure for `erp_finished_production`
-- ----------------------------
DROP TABLE IF EXISTS `erp_finished_production`;
CREATE TABLE `erp_finished_production` (
  `id` varchar(32) NOT NULL,
  `name` varchar(250) DEFAULT NULL COMMENT '加工品名称',
  `add_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '入库时间',
  `out_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '出库时间',
  `add_num` varchar(250) DEFAULT NULL COMMENT '入库数量',
  `out_num` varchar(250) DEFAULT NULL COMMENT '出库数量',
  `person_name` varchar(250) DEFAULT NULL COMMENT '加工品入库责任人',
  `other` varchar(250) DEFAULT NULL COMMENT '其他',
  `flag` varchar(1) DEFAULT NULL COMMENT '表区分标识，，1：加工品管理表，2，完成品表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='加工品管理表';

-- ----------------------------
-- Records of erp_finished_production
-- ----------------------------
INSERT INTO `erp_finished_production` VALUES ('31acf60a0ace4960bf055bd7542e02d6', '测试', '2018-04-07 20:14:29', '2018-04-07 20:14:29', '测试', null, '测试', '测试', null);

-- ----------------------------
-- Table structure for `erp_order`
-- ----------------------------
DROP TABLE IF EXISTS `erp_order`;
CREATE TABLE `erp_order` (
  `id` varchar(32) NOT NULL,
  `name` varchar(250) DEFAULT NULL COMMENT '订单名称',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `end_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` varchar(1) DEFAULT '1',
  `proble_order` varchar(250) DEFAULT '0' COMMENT '问题订单 0:有效1：无效2问题订单',
  `order_process` varchar(50) DEFAULT '1' COMMENT '订单流程（1，下达订单，2，制定生产工艺，3，生产计划管理、4，生产任务管理、5，原材料发放、6，加工、7，印染、8，成品、9，订单完成）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `oid` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of erp_order
-- ----------------------------
INSERT INTO `erp_order` VALUES ('19de7ec63e6e4d5ea233a9647bf92deb', '测试订单3', '2018-03-14 22:59:33', '2018-03-14 22:59:33', '1', '0', '1');
INSERT INTO `erp_order` VALUES ('1a7c961bc52b496aaacc49843030e13f', '测试下订单', '2018-03-14 22:56:47', '2018-03-21 15:17:14', '1', '0', '2');
INSERT INTO `erp_order` VALUES ('215dc4e9fe054dd396d290ada9005e0a', '测试订单1', '2018-03-13 21:52:53', '2018-03-14 23:08:03', '0', '0', '1');
INSERT INTO `erp_order` VALUES ('23d07d11607c45efa5dc6e4d01a2db4d', '新增订单4', '2018-03-14 23:00:29', '2018-03-21 21:47:18', '1', '0', '2');
INSERT INTO `erp_order` VALUES ('3cbf80bc02634c3db40d964137d1b814', '下单订单1', '2018-05-01 10:44:42', '2018-05-13 16:25:53', '1', '0', '1');
INSERT INTO `erp_order` VALUES ('667efb393b4541bbb3e1f7944a0b7025', '测试订单2', '2018-03-14 22:58:40', '2018-03-21 21:44:28', '1', '0', '2');

-- ----------------------------
-- Table structure for `erp_order_production_releationship`
-- ----------------------------
DROP TABLE IF EXISTS `erp_order_production_releationship`;
CREATE TABLE `erp_order_production_releationship` (
  `id` varchar(32) NOT NULL,
  `order_id` varchar(32) DEFAULT NULL COMMENT '订单id',
  `production_id` varchar(32) DEFAULT NULL COMMENT '工艺生产id',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '生成时间',
  `order_name` varchar(50) DEFAULT NULL,
  `production_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单，生产关系，关联表';

-- ----------------------------
-- Records of erp_order_production_releationship
-- ----------------------------
INSERT INTO `erp_order_production_releationship` VALUES ('577f7dd100d040afad7b81e841f521fe', '667efb393b4541bbb3e1f7944a0b7025', '516a34cc1b574af8bfdd0125f49245c1', '2018-03-21 21:44:28', '测试订单2', '制定水泥工艺品');
INSERT INTO `erp_order_production_releationship` VALUES ('5de326fdd8094f8d978ac3a2656b0b4c', '23d07d11607c45efa5dc6e4d01a2db4d', '1c2e5f5983b848a59b885316982f107f', '2018-03-21 21:47:18', '新增订单4', '水泥工艺2');
INSERT INTO `erp_order_production_releationship` VALUES ('a893071ead6a4887bb81187a37ff7f26', '1a7c961bc52b496aaacc49843030e13f', 'fce07b3e1c7747c3bf6b4e5e2f379612', '2018-03-21 15:17:10', '测试下订单', '晚点点');

-- ----------------------------
-- Table structure for `erp_out_company`
-- ----------------------------
DROP TABLE IF EXISTS `erp_out_company`;
CREATE TABLE `erp_out_company` (
  `id` varchar(32) NOT NULL,
  `name` varchar(250) DEFAULT NULL COMMENT '外协公司名称',
  `task_name` varchar(250) DEFAULT NULL COMMENT '任务名称',
  `task_id` varchar(250) DEFAULT NULL COMMENT '任务编号',
  `task_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '任务时间',
  `plan_rawmaterial` varchar(250) DEFAULT NULL COMMENT '预计原材料使用量',
  `now_rawmaterial_num` varchar(250) DEFAULT NULL COMMENT '现有原材料量',
  `append` varchar(2) DEFAULT NULL COMMENT '是否需要添加',
  `append_num` varchar(250) DEFAULT NULL COMMENT '添加数量',
  `append_context` varchar(250) DEFAULT NULL COMMENT '添置内容',
  `surplus` varchar(250) DEFAULT NULL COMMENT '是否剩余',
  `surplus_num` varchar(250) DEFAULT NULL COMMENT '剩余数量',
  `return` varchar(250) DEFAULT NULL COMMENT '是否归还',
  `return_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '归还时间',
  `return_num` varchar(250) DEFAULT NULL COMMENT '归还数量',
  `finshed_task` varchar(250) DEFAULT NULL COMMENT '任务是否完成',
  `other` varchar(250) DEFAULT NULL COMMENT '未完成后续内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='外协企业表';

-- ----------------------------
-- Records of erp_out_company
-- ----------------------------
INSERT INTO `erp_out_company` VALUES ('c67e99c6dadb4fcf9ff4dc1561882960', '测试', '测试', '测试', '2018-04-07 19:46:03', null, null, null, null, null, null, null, null, '2018-04-07 19:46:03', null, null, '测试');

-- ----------------------------
-- Table structure for `erp_production`
-- ----------------------------
DROP TABLE IF EXISTS `erp_production`;
CREATE TABLE `erp_production` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '生产工艺名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工艺表';

-- ----------------------------
-- Records of erp_production
-- ----------------------------

-- ----------------------------
-- Table structure for `erp_production_detail`
-- ----------------------------
DROP TABLE IF EXISTS `erp_production_detail`;
CREATE TABLE `erp_production_detail` (
  `id` varchar(32) NOT NULL,
  `material_name` varchar(250) DEFAULT NULL COMMENT '材料名称',
  `specif` varchar(250) DEFAULT NULL COMMENT '规格',
  `weigth` varchar(250) DEFAULT NULL COMMENT '重量',
  `other` varchar(250) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工艺详情表';

-- ----------------------------
-- Records of erp_production_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `erp_production_plan`
-- ----------------------------
DROP TABLE IF EXISTS `erp_production_plan`;
CREATE TABLE `erp_production_plan` (
  `id` varchar(32) NOT NULL,
  `name` varchar(250) DEFAULT NULL COMMENT '生产计划名称',
  `production_name` varchar(250) DEFAULT NULL COMMENT '工艺名称',
  `production_id` varchar(250) DEFAULT NULL COMMENT '工艺id',
  `rawmaterialr_name` varchar(250) DEFAULT NULL COMMENT '原材料名称',
  `rawmaterial_id` varchar(250) DEFAULT NULL COMMENT '原材料id',
  `plan_time` varchar(50) DEFAULT 'CURRENT_TIMESTAMP' COMMENT '计划时间',
  `judge` varchar(250) DEFAULT NULL COMMENT '是否改为分配',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产计划表';

-- ----------------------------
-- Records of erp_production_plan
-- ----------------------------
INSERT INTO `erp_production_plan` VALUES ('b7d991e1aa9f45e6be34c0d5b841e38f', 'ASD', 'ASD', 'b7d991e1aa9f45e6be34c0d5b841e38f', 'ASD', 'b7d991e1aa9f45e6be34c0d5b841e38f', 'ASD', '0');
INSERT INTO `erp_production_plan` VALUES ('bbecb33ab8ca4432872cbbd88ea480fb', '测试', '测试', 'bbecb33ab8ca4432872cbbd88ea480fb', '测试', 'bbecb33ab8ca4432872cbbd88ea480fb', '10', '0');

-- ----------------------------
-- Table structure for `erp_production_process_releationship`
-- ----------------------------
DROP TABLE IF EXISTS `erp_production_process_releationship`;
CREATE TABLE `erp_production_process_releationship` (
  `id` varchar(32) NOT NULL,
  `production_name` varchar(250) DEFAULT NULL COMMENT '生产工艺名称',
  `rawmaterial_name` varchar(250) DEFAULT NULL COMMENT '原材料名称',
  `rawmaterial_id` varchar(250) DEFAULT NULL COMMENT '原材料id',
  `num` varchar(250) DEFAULT NULL COMMENT '使用数量',
  `work_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '加工时间',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `end_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产工艺关系表';

-- ----------------------------
-- Records of erp_production_process_releationship
-- ----------------------------
INSERT INTO `erp_production_process_releationship` VALUES ('1c2e5f5983b848a59b885316982f107f', '水泥工艺2', '水泥', '1869031307844de1bfd6208808cc3fd8', '134', '2018-03-23 00:00:00', '2018-03-21 21:47:18', '2018-03-21 21:47:18', '1');
INSERT INTO `erp_production_process_releationship` VALUES ('516a34cc1b574af8bfdd0125f49245c1', '制定水泥工艺品', '水泥', '1869031307844de1bfd6208808cc3fd8', '120', '2018-03-22 00:00:00', '2018-03-21 21:44:28', '2018-03-21 21:44:28', '1');
INSERT INTO `erp_production_process_releationship` VALUES ('fce07b3e1c7747c3bf6b4e5e2f379612', '晚点点', '水泥', '1869031307844de1bfd6208808cc3fd8', '100', '2018-03-23 00:00:00', '2018-03-21 15:16:50', '2018-03-21 15:16:50', '1');

-- ----------------------------
-- Table structure for `erp_rawmaterial`
-- ----------------------------
DROP TABLE IF EXISTS `erp_rawmaterial`;
CREATE TABLE `erp_rawmaterial` (
  `id` varchar(32) NOT NULL,
  `name` varchar(250) DEFAULT NULL COMMENT '材料名称',
  `num` varchar(250) DEFAULT NULL COMMENT '材料数量',
  `dutyer` varchar(250) DEFAULT NULL COMMENT '负责人',
  `surplus` varchar(250) DEFAULT NULL COMMENT '剩余数量',
  `outnum` varchar(250) DEFAULT '0' COMMENT '出货数量',
  `purchase_num` varchar(250) DEFAULT '0' COMMENT '购货次数',
  `shipment_num` varchar(250) DEFAULT '0' COMMENT '出货次数',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `end_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(1) DEFAULT '1',
  `person` varchar(50) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='材料表';

-- ----------------------------
-- Records of erp_rawmaterial
-- ----------------------------
INSERT INTO `erp_rawmaterial` VALUES ('1869031307844de1bfd6208808cc3fd8', '水泥', '1000', '小王', '546', '454', '0', '4', '2018-03-17 19:39:56', '2018-03-21 21:47:18', '1', null, null);
INSERT INTO `erp_rawmaterial` VALUES ('2cf45e46699d4a48b12a407ffbe90878', 'QQQ', '12', 'ABC', '12', '0', '0', '0', '2018-04-07 11:57:13', '2018-04-07 11:57:13', '1', null, null);
INSERT INTO `erp_rawmaterial` VALUES ('77334d06703a4e31aa78d455bad9de19', '测试物料', '100', '小黄', '100', '0', '0', '0', '2018-03-17 19:38:06', '2018-03-21 14:55:30', '1', null, null);
INSERT INTO `erp_rawmaterial` VALUES ('c31f9a031073492c815c3cce04caa411', 'ASD', 'ASD', 'ASD', 'ASD', '0', '0', '0', '2018-05-01 10:08:00', '2018-05-01 10:08:00', '1', null, null);

-- ----------------------------
-- Table structure for `erp_supplier`
-- ----------------------------
DROP TABLE IF EXISTS `erp_supplier`;
CREATE TABLE `erp_supplier` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '供应商名称',
  `company` varchar(250) DEFAULT NULL COMMENT '公司名称',
  `address` varchar(250) DEFAULT NULL COMMENT '公司地址',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `end_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商详情';

-- ----------------------------
-- Records of erp_supplier
-- ----------------------------
INSERT INTO `erp_supplier` VALUES ('3743e9aea01a46e79b16e7c154042a9f', '花生', '来福寺贸易', '苏州市', '2018-03-18 13:46:24', '2018-03-18 13:48:05', '1');
INSERT INTO `erp_supplier` VALUES ('47a1b32ac80347ffad7a6d9f6f15db15', '可乐', '阿里巴巴商务', '杭州市', '2018-03-18 13:47:50', '2018-03-18 13:47:50', '1');

-- ----------------------------
-- Table structure for `erp_supplier_rawmaterial_releationship`
-- ----------------------------
DROP TABLE IF EXISTS `erp_supplier_rawmaterial_releationship`;
CREATE TABLE `erp_supplier_rawmaterial_releationship` (
  `id` varchar(50) NOT NULL,
  `supplier_name` varchar(250) DEFAULT NULL COMMENT '供货商名称',
  `supplier_id` varchar(250) DEFAULT NULL COMMENT '供货商id',
  `rawmaterial_name` varchar(250) DEFAULT NULL COMMENT '原材料名称',
  `rawmaterial_id` varchar(250) DEFAULT NULL COMMENT '原材料id',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `end_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='供应商，材料，关系表';

-- ----------------------------
-- Records of erp_supplier_rawmaterial_releationship
-- ----------------------------

-- ----------------------------
-- Table structure for `erp_task`
-- ----------------------------
DROP TABLE IF EXISTS `erp_task`;
CREATE TABLE `erp_task` (
  `id` varchar(32) NOT NULL,
  `name` varchar(250) DEFAULT NULL COMMENT '任务名称',
  `context` varchar(250) DEFAULT NULL COMMENT '任务内容',
  `start_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '任务开始时间',
  `end_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '任务结束时间',
  `outcompany_hep` varchar(250) DEFAULT NULL COMMENT '是否外协',
  `commiect` varchar(2) DEFAULT NULL COMMENT '是否提交',
  `finished` varchar(2) DEFAULT NULL COMMENT '是否完成',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务表';

-- ----------------------------
-- Records of erp_task
-- ----------------------------
INSERT INTO `erp_task` VALUES ('de0fed4fe70c453e9bfb09a76567f8f9', '棉麻窗帘', '生产棉麻窗帘', '2018-05-01 10:36:40', '2018-05-01 10:36:40', '是', '1', '分配');

-- ----------------------------
-- Table structure for `erp_user`
-- ----------------------------
DROP TABLE IF EXISTS `erp_user`;
CREATE TABLE `erp_user` (
  `id` varchar(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `number` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of erp_user
-- ----------------------------
