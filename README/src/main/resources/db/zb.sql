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

 Date: 28/05/2022 13:06:08
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
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of zb
-- ----------------------------
INSERT INTO `zb` VALUES (1, 'ZB-35bc36ff1f374f46b5e0562f25ff8681', '中国生物制药公司', '盒装', '2000', '2022-05-28 13:05:07', '2022-05-28 13:05:10', '青霉素', 'admin@test.com', 0, '招标...');

SET FOREIGN_KEY_CHECKS = 1;
