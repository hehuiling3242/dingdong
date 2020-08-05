/*
 Navicat Premium Data Transfer

 Source Server         : ceshi
 Source Server Type    : MariaDB
 Source Server Version : 100119
 Source Host           : localhost:3306
 Source Schema         : dingdong

 Target Server Type    : MariaDB
 Target Server Version : 100119
 File Encoding         : 65001

 Date: 03/08/2020 09:15:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for commodity_classify
-- ----------------------------
DROP TABLE IF EXISTS `commodity_classify`;
CREATE TABLE `commodity_classify`  (
  `class_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品分类名',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for commodity_details
-- ----------------------------
DROP TABLE IF EXISTS `commodity_details`;
CREATE TABLE `commodity_details`  (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `class_id` int(11) NOT NULL COMMENT '商品分类id',
  `price` decimal(11, 0) NOT NULL COMMENT '价格',
  `digg` int(11) NOT NULL COMMENT '产品评价',
  `about` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品介绍',
  `detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '规格',
  `count` int(11) NOT NULL COMMENT '库存',
  `product_show` tinyint(11) NOT NULL COMMENT '0是新品，1是促销',
  `main_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品主图',
  `sub_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品详情图',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `sex` tinyint(11) NULL DEFAULT NULL COMMENT '性别',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生日',
  `city_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `post_code` int(11) NULL DEFAULT NULL COMMENT '邮编',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (0, '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (1, 'dingding', '123456', '钉钉', 1, '11111111111', '1998.09.12', '1', '1', 0);
INSERT INTO `user` VALUES (2, 'haha', '123456', '哈哈', 0, '2222222222', '1982.06.22', '2', '2', 0);
INSERT INTO `user` VALUES (3, 'heihei', '123456', '嘿嘿', 1, '33333333333', '1956.09.14', '3', '3', 0);

SET FOREIGN_KEY_CHECKS = 1;
