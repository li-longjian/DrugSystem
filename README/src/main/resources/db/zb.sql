/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : yaomanagement

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 04/06/2022 23:54:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for zb
-- ----------------------------
DROP TABLE IF EXISTS `zb`;
CREATE TABLE `zb`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '招标编号',
  `companyName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '招标公司名称',
  `packaged` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '包装要求',
  `total` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '总量',
  `expirationDate` datetime NULL DEFAULT NULL COMMENT '截止时间',
  `date` datetime NULL DEFAULT NULL COMMENT '当前发布时间',
  `durgName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '招标药品名称',
  `announcer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发布者email',
  `status` int NULL DEFAULT NULL COMMENT '招标状态，1代表已接受投标，0：等待投标',
  `marked` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '留言，备注信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zb
-- ----------------------------
INSERT INTO `zb` VALUES (1, 'ZB-35bc36ff1f374f46b5e0562f25ff8681', '中国医药集团有限公司', '盒装', '2000', '2022-06-03 16:44:15', '2022-05-28 13:05:10', '青霉素', 'zhangsan@test.com', 0, '招标中！！！');
INSERT INTO `zb` VALUES (2, 'ZB-2cdc533d8f2046f685ee871efba3f9f3', '江苏恒瑞医药股份有限公司', '盒装', '20000', '2022-06-03 18:55:51', '2022-06-03 08:55:32', '苯唑西林', 'zhangsan@test.com', 0, '招标中！！！');
INSERT INTO `zb` VALUES (3, 'ZB-10c432e9f4d44f9e85737e9e1ab9b474', '深圳迈瑞生物医疗电子股份有限公司', '片剂', '20000', '2022-06-03 16:58:21', '2022-06-03 08:58:14', '阿莫西林克拉维酸钾', 'zhangsan@test.com', 0, '招标中！！！');
INSERT INTO `zb` VALUES (4, 'ZB-e679659439b5441eb40d358bd857b37c', '上海复星医药(集团)股份有限公司', '注射用无菌粉末', '20000', '2022-06-03 17:00:20', '2022-06-03 09:00:10', '头孢唑林', 'zhangsan@test.com', 0, '招标中！！！');
INSERT INTO `zb` VALUES (5, 'ZB-ab62f76454304def9841611e55a0bf68', '云南白药集团股份有限公司', '盒', '20000', '2022-06-03 17:01:30', '2022-06-03 09:01:09', '云南白药', 'zhangsan@test.com', 0, '招标中！！！');
INSERT INTO `zb` VALUES (6, 'ZB-ed97817da26d4192a207b0b440b7515f', '杭州泰格医药科技股份有限公司', '注射液', '20000', '2022-06-03 17:04:55', '2022-06-03 09:02:18', '阿米卡星', 'zhangsan@test.com', 0, '招标中！！！');
INSERT INTO `zb` VALUES (7, 'ZB-80eaf59cc08744d486795a41475b194d', '杭州泰格医药科技股份有限公司', '注射液', '10000', '2022-06-03 17:04:58', '2022-06-03 09:02:54', '庆大霉素', 'zhangsan@test.com', 0, '招标中！！！');
INSERT INTO `zb` VALUES (8, 'ZB-937319bb377648a9a78a794da3514002', '信达生物制药（苏州）有限公司', '片剂、胶囊', '10000', '2022-06-03 17:05:01', '2022-06-03 09:03:39', '克林霉素', 'zhangsan@test.com', 0, '招标中！！！');
INSERT INTO `zb` VALUES (9, 'ZB-b39f5ca9bd844604a8e9349f53a66456', '深圳康泰生物制品股份有限公司', '片剂', '10000', '2022-06-03 17:05:03', '2022-06-03 09:04:21', '复斱磺胺甲 唑', 'zhangsan@test.com', 0, '招标中！！！');
INSERT INTO `zb` VALUES (16, 'ZB-6bc8d9b56071493faa299f4c8ea4f78b', '深圳康泰生物制品股份有限公司', '片剂', '10000', '2022-06-03 17:07:08', '2022-06-03 09:07:02', '磺胺嘧啶', 'zhangsan@test.com', 0, '招标中！！！');

SET FOREIGN_KEY_CHECKS = 1;
