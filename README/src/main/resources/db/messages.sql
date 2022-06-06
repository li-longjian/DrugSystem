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

 Date: 06/06/2022 16:15:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `announcer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发布者',
  `describe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '留言信息',
  `status` int NULL DEFAULT NULL COMMENT '留言状态',
  `companyName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公司名称',
  `date` datetime NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of messages
-- ----------------------------
INSERT INTO `messages` VALUES (1, 'admin@test.com', '留言测试1', 0, 'admin', '2022-06-06 14:40:12');
INSERT INTO `messages` VALUES (2, 'admin@test.com', '留言测试2', 0, 'admin', '2022-06-06 14:46:44');
INSERT INTO `messages` VALUES (3, 'admin@test.com', '留言测试3', 0, 'admin', '2022-06-06 14:51:48');
INSERT INTO `messages` VALUES (4, 'admin@test.com', '留言测试4', 0, 'admin', '2022-06-06 14:58:50');
INSERT INTO `messages` VALUES (5, 'admin@test.com', '留言测试5', 0, 'admin', '2022-06-06 14:59:39');
INSERT INTO `messages` VALUES (6, 'admin@test.com', '留言测试6', 0, 'admin', '2022-06-06 15:01:42');
INSERT INTO `messages` VALUES (7, 'admin@test.com', '留言测试7-修改', 0, 'admin', '2022-06-06 15:19:08');

SET FOREIGN_KEY_CHECKS = 1;
