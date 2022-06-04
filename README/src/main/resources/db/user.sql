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

 Date: 04/06/2022 23:54:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `isAdmin` int NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `date` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `identity` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 1, 'admin', 'admin@test.com', '4E8466EEA55324931E3C4DC18DC24F1B', NULL, '2022-05-29 15:12:42', '管理员');
INSERT INTO `user` VALUES (2, 0, '张三', 'zhangsan@test.com', 'E91FDC6C5F3AE7EEEDF4167C43AE0528', NULL, '2022-05-29 15:15:36', '药品招标单位');
INSERT INTO `user` VALUES (3, 0, '李四', 'lisi@test.com', '1371BA466AFCDC6D1DAE01823719CC59', NULL, '2022-05-29 15:16:17', '药品招标单位');
INSERT INTO `user` VALUES (4, 0, 'test', 'test@test.com', '528E0C5FC909816F515D200EC60F7C0B', NULL, '2022-05-29 14:07:19', '药品投标单位');

SET FOREIGN_KEY_CHECKS = 1;
