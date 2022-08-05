-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.30 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 srcode 的数据库结构
CREATE DATABASE IF NOT EXISTS `srcode` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `srcode`;

-- 导出  表 srcode.emission_board 结构
CREATE TABLE IF NOT EXISTS `emission_board` (
  `id` int NOT NULL AUTO_INCREMENT,
  `model_id` int NOT NULL DEFAULT '0',
  `track_id` int NOT NULL DEFAULT '0',
  `compute_value` double NOT NULL DEFAULT '0' COMMENT '增量值',
  `cumulative_value` double NOT NULL DEFAULT '0' COMMENT '累计值',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_ctime` (`create_time`) USING BTREE,
  KEY `idx_track_id` (`track_id`) USING BTREE,
  KEY `idx_utime` (`update_time`) USING BTREE,
  KEY `idx_cum` (`cumulative_value`) USING BTREE,
  KEY `idx_model_id` (`model_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=256 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='排放看板表';

-- 正在导出表  srcode.emission_board 的数据：~255 rows (大约)
/*!40000 ALTER TABLE `emission_board` DISABLE KEYS */;
INSERT INTO `emission_board` (`id`, `model_id`, `track_id`, `compute_value`, `cumulative_value`, `update_time`, `create_time`) VALUES
	(1, 36, 79, 3201.493959, 3201.493959, '2022-07-14 17:10:54', '2022-07-14 17:10:54'),
	(2, 17, 82, 2602.3336504900003, 2602.3336504900003, '2022-07-14 17:10:57', '2022-07-14 17:10:57'),
	(3, 17, 49, 2602.3336504900003, 2602.3336504900003, '2022-07-27 18:36:58', '2022-07-14 17:11:05'),
	(4, 17, 82, 2399.806399292273, 2399.806399292273, '2022-07-14 17:11:06', '2022-07-14 17:11:06'),
	(5, 17, 49, 195956.02203691215, 195956.02203691215, '2022-07-27 18:36:58', '2022-07-14 17:11:07'),
	(6, 19, 66, 8.5773212, 8.5773212, '2022-07-14 17:11:08', '2022-07-14 17:11:08'),
	(7, 17, 49, 2399.806399292273, 2399.806399292273, '2022-07-27 18:36:58', '2022-07-14 17:11:10'),
	(8, 19, 49, 803.88, 803.88, '2022-07-27 18:36:58', '2022-07-14 17:11:12'),
	(9, 19, 66, 9.025704209487177, 9.025704209487177, '2022-07-14 17:11:14', '2022-07-14 17:11:14'),
	(10, 17, 82, 1113.149594938684, 1113.149594938684, '2022-07-14 17:11:15', '2022-07-14 17:11:15'),
	(11, 17, 49, 195563.31917141896, 195563.31917141896, '2022-07-27 18:36:58', '2022-07-14 17:11:16'),
	(12, 17, 49, 1113.149594938684, 1113.149594938684, '2022-07-27 18:36:58', '2022-07-14 17:11:16'),
	(13, 17, 49, 195508.88455985032, 195508.88455985032, '2022-07-27 18:36:58', '2022-07-14 17:11:17'),
	(14, 18, 49, 14.46578841448276, 14.46578841448276, '2022-07-27 18:36:58', '2022-07-14 17:11:18'),
	(15, 17, 82, 195956.02203691215, 195956.02203691215, '2022-07-14 17:11:19', '2022-07-14 17:11:19'),
	(16, 19, 66, 188.99249283352944, 188.99249283352944, '2022-07-14 17:11:19', '2022-07-14 17:11:19'),
	(17, 17, 82, 1118.64156604, 1118.64156604, '2022-07-14 17:11:20', '2022-07-14 17:11:20'),
	(18, 17, 49, 1118.64156604, 1118.64156604, '2022-07-27 18:36:58', '2022-07-14 17:11:20'),
	(19, 19, 49, 8.5773212, 8.5773212, '2022-07-27 18:36:58', '2022-07-14 17:11:22'),
	(20, 19, 66, 194.71738748, 194.71738748, '2022-07-14 17:11:22', '2022-07-14 17:11:22'),
	(21, 18, 82, 11292.047561971058, 11292.047561971058, '2022-07-14 17:11:23', '2022-07-14 17:11:23'),
	(22, 17, 49, 195611.6596760023, 195611.6596760023, '2022-07-27 18:36:58', '2022-07-14 17:11:24'),
	(23, 18, 82, 14.46578841448276, 14.46578841448276, '2022-07-14 17:11:25', '2022-07-14 17:11:25'),
	(24, 18, 82, 14.52091968478261, 14.52091968478261, '2022-07-14 17:11:26', '2022-07-14 17:11:26'),
	(25, 20, 49, 5.119899033030305, 5.119899033030305, '2022-07-27 18:36:58', '2022-07-14 17:11:26'),
	(26, 19, 66, 803.88, 803.88, '2022-07-14 17:11:26', '2022-07-14 17:11:26'),
	(27, 18, 49, 14.52091968478261, 14.52091968478261, '2022-07-27 18:36:58', '2022-07-14 17:11:27'),
	(28, 20, 49, 11230.377024761648, 11230.377024761648, '2022-07-27 18:36:58', '2022-07-14 17:11:28'),
	(29, 20, 49, 11248.33806474011, 11248.33806474011, '2022-07-27 18:36:58', '2022-07-14 17:11:28'),
	(30, 17, 82, 195563.31917141896, 195563.31917141896, '2022-07-14 17:11:28', '2022-07-14 17:11:28'),
	(31, 18, 82, 11295.08649787284, 11295.08649787284, '2022-07-14 17:11:28', '2022-07-14 17:11:28'),
	(32, 18, 49, 11292.047561971058, 11292.047561971058, '2022-07-27 18:36:58', '2022-07-14 17:11:29'),
	(33, 18, 49, 11295.08649787284, 11295.08649787284, '2022-07-27 18:36:58', '2022-07-14 17:11:30'),
	(34, 19, 49, 9.025704209487177, 9.025704209487177, '2022-07-27 18:36:58', '2022-07-14 17:11:31'),
	(35, 17, 82, 195508.88455985032, 195508.88455985032, '2022-07-14 17:11:31', '2022-07-14 17:11:31'),
	(36, 18, 49, 7471.090016136368, 7471.090016136368, '2022-07-27 18:36:58', '2022-07-14 17:11:31'),
	(37, 20, 49, 5.117622721891893, 5.117622721891893, '2022-07-27 18:36:58', '2022-07-14 17:11:32'),
	(38, 18, 82, 3.1458952879487176, 3.1458952879487176, '2022-07-14 17:11:33', '2022-07-14 17:11:33'),
	(39, 18, 49, 3.1458952879487176, 3.1458952879487176, '2022-07-27 18:36:58', '2022-07-14 17:11:33'),
	(40, 17, 82, 195611.6596760023, 195611.6596760023, '2022-07-14 17:11:34', '2022-07-14 17:11:34'),
	(41, 18, 82, 7471.090016136368, 7471.090016136368, '2022-07-14 17:11:35', '2022-07-14 17:11:35'),
	(42, 19, 49, 188.99249283352944, 188.99249283352944, '2022-07-27 18:36:58', '2022-07-14 17:11:36'),
	(43, 20, 49, 264.72397234818186, 264.72397234818186, '2022-07-27 18:36:58', '2022-07-14 17:11:36'),
	(44, 20, 49, 7421.332782733096, 7421.332782733096, '2022-07-27 18:36:58', '2022-07-14 17:11:37'),
	(45, 19, 49, 194.71738748, 194.71738748, '2022-07-27 18:36:58', '2022-07-14 17:11:39'),
	(46, 20, 49, 7357.432446529992, 7357.432446529992, '2022-07-27 18:36:58', '2022-07-14 17:11:40'),
	(47, 18, 49, 23070.343530998634, 23070.343530998634, '2022-07-27 18:36:58', '2022-07-14 17:11:40'),
	(48, 18, 82, 3.33835928125, 3.33835928125, '2022-07-14 17:11:41', '2022-07-14 17:11:41'),
	(49, 18, 82, 23070.343530998634, 23070.343530998634, '2022-07-14 17:11:41', '2022-07-14 17:11:41'),
	(50, 18, 49, 3.33835928125, 3.33835928125, '2022-07-27 18:36:58', '2022-07-14 17:11:42'),
	(51, 20, 49, 274.7688982033333, 274.7688982033333, '2022-07-27 18:36:58', '2022-07-14 17:11:44'),
	(52, 20, 49, 0, 11230.377024761648, '2022-07-27 18:36:58', '2022-07-15 00:00:00'),
	(53, 20, 49, 0, 11248.33806474011, '2022-07-27 18:36:58', '2022-07-15 00:00:02'),
	(54, 36, 79, 0, 3201.493959, '2022-07-15 00:00:04', '2022-07-15 00:00:04'),
	(55, 20, 49, 0, 7421.332782733096, '2022-07-27 18:36:58', '2022-07-15 00:00:07'),
	(56, 20, 49, 0, 7357.432446529992, '2022-07-27 18:36:58', '2022-07-15 00:00:09'),
	(57, 17, 49, 0, 195956.02203691215, '2022-07-27 18:36:58', '2022-07-15 00:00:10'),
	(58, 18, 82, 0, 11292.047561971058, '2022-07-15 00:00:14', '2022-07-15 00:00:14'),
	(59, 17, 49, 0, 195563.31917141896, '2022-07-27 18:36:58', '2022-07-15 00:00:18'),
	(60, 20, 49, 0, 5.119899033030305, '2022-07-27 18:36:58', '2022-07-15 00:00:19'),
	(61, 18, 49, 0, 11292.047561971058, '2022-07-27 18:36:58', '2022-07-15 00:00:20'),
	(62, 20, 49, 0, 5.117622721891893, '2022-07-27 18:36:58', '2022-07-15 00:00:22'),
	(63, 18, 82, 0, 11295.08649787284, '2022-07-15 00:00:22', '2022-07-15 00:00:22'),
	(64, 18, 49, 0, 11295.08649787284, '2022-07-27 18:36:58', '2022-07-15 00:00:22'),
	(65, 20, 49, 0, 264.72397234818186, '2022-07-27 18:36:58', '2022-07-15 00:00:25'),
	(66, 18, 82, 0, 7471.090016136368, '2022-07-15 00:00:25', '2022-07-15 00:00:25'),
	(67, 17, 49, 0, 195508.88455985032, '2022-07-27 18:36:58', '2022-07-15 00:00:25'),
	(68, 20, 49, 0, 274.7688982033333, '2022-07-27 18:36:58', '2022-07-15 00:00:26'),
	(69, 18, 82, 0, 23070.343530998634, '2022-07-15 00:00:29', '2022-07-15 00:00:29'),
	(70, 18, 49, 0, 7471.090016136368, '2022-07-27 18:36:58', '2022-07-15 00:00:30'),
	(71, 18, 49, 0, 23070.343530998634, '2022-07-27 18:36:58', '2022-07-15 00:00:33'),
	(72, 17, 49, 0, 195611.6596760023, '2022-07-27 18:36:58', '2022-07-15 00:00:33'),
	(73, 17, 49, 0, 2602.3336504900003, '2022-07-27 18:36:58', '2022-07-15 00:00:34'),
	(74, 17, 49, 0, 2399.806399292273, '2022-07-27 18:36:58', '2022-07-15 00:00:35'),
	(75, 17, 49, 0, 1113.149594938684, '2022-07-27 18:36:58', '2022-07-15 00:00:36'),
	(76, 19, 66, 0, 803.88, '2022-07-15 00:00:36', '2022-07-15 00:00:36'),
	(77, 17, 49, 0, 1118.64156604, '2022-07-27 18:36:58', '2022-07-15 00:00:44'),
	(78, 18, 82, 0, 14.46578841448276, '2022-07-15 00:00:46', '2022-07-15 00:00:46'),
	(79, 19, 49, 0, 803.88, '2022-07-27 18:36:58', '2022-07-15 00:00:48'),
	(80, 18, 82, 0, 14.52091968478261, '2022-07-15 00:00:55', '2022-07-15 00:00:55'),
	(81, 19, 49, 0, 8.5773212, '2022-07-27 18:36:58', '2022-07-15 00:00:58'),
	(82, 19, 49, 0, 9.025704209487177, '2022-07-27 18:36:58', '2022-07-15 00:00:58'),
	(83, 19, 49, 0, 188.99249283352944, '2022-07-27 18:36:58', '2022-07-15 00:00:58'),
	(84, 19, 49, 0, 194.71738748, '2022-07-27 18:36:58', '2022-07-15 00:01:01'),
	(85, 18, 82, 0, 3.1458952879487176, '2022-07-15 00:01:04', '2022-07-15 00:01:04'),
	(86, 17, 82, 0, 2602.3336504900003, '2022-07-15 00:01:08', '2022-07-15 00:01:08'),
	(87, 17, 82, 0, 2399.806399292273, '2022-07-15 00:01:08', '2022-07-15 00:01:08'),
	(88, 18, 82, 0, 3.33835928125, '2022-07-15 00:01:11', '2022-07-15 00:01:11'),
	(89, 19, 66, 0, 8.5773212, '2022-07-15 00:01:12', '2022-07-15 00:01:12'),
	(90, 18, 49, 0, 14.46578841448276, '2022-07-27 18:36:58', '2022-07-15 00:01:12'),
	(91, 17, 82, 0, 195956.02203691215, '2022-07-15 00:01:14', '2022-07-15 00:01:14'),
	(92, 17, 82, 0, 1113.149594938684, '2022-07-15 00:01:15', '2022-07-15 00:01:15'),
	(93, 17, 82, 0, 1118.64156604, '2022-07-15 00:01:16', '2022-07-15 00:01:16'),
	(94, 18, 49, 0, 14.52091968478261, '2022-07-27 18:36:58', '2022-07-15 00:01:16'),
	(95, 18, 49, 0, 3.1458952879487176, '2022-07-27 18:36:58', '2022-07-15 00:01:19'),
	(96, 19, 66, 0, 9.025704209487177, '2022-07-15 00:01:20', '2022-07-15 00:01:20'),
	(97, 17, 82, 0, 195563.31917141896, '2022-07-15 00:01:21', '2022-07-15 00:01:21'),
	(98, 18, 49, 0, 3.33835928125, '2022-07-27 18:36:58', '2022-07-15 00:01:23'),
	(99, 19, 66, 0, 188.99249283352944, '2022-07-15 00:01:24', '2022-07-15 00:01:24'),
	(100, 19, 66, 0, 194.71738748, '2022-07-15 00:01:25', '2022-07-15 00:01:25'),
	(101, 17, 82, 0, 195508.88455985032, '2022-07-15 00:01:28', '2022-07-15 00:01:28'),
	(102, 17, 82, 0, 195611.6596760023, '2022-07-15 00:01:35', '2022-07-15 00:01:35'),
	(103, 18, 82, 0, 11292.047561971058, '2022-07-16 00:00:08', '2022-07-16 00:00:08'),
	(104, 19, 49, 0, 803.88, '2022-07-27 18:36:58', '2022-07-16 00:00:09'),
	(105, 18, 82, 0, 11295.08649787284, '2022-07-16 00:00:10', '2022-07-16 00:00:10'),
	(106, 17, 49, 0, 195956.02203691215, '2022-07-27 18:36:58', '2022-07-16 00:00:10'),
	(107, 18, 49, 0, 11292.047561971058, '2022-07-27 18:36:58', '2022-07-16 00:00:12'),
	(108, 18, 82, 0, 7471.090016136368, '2022-07-16 00:00:12', '2022-07-16 00:00:12'),
	(109, 17, 82, 0, 195956.02203691215, '2022-07-16 00:00:14', '2022-07-16 00:00:14'),
	(110, 17, 49, 0, 195563.31917141896, '2022-07-27 18:36:58', '2022-07-16 00:00:14'),
	(111, 18, 82, 0, 23070.343530998634, '2022-07-16 00:00:18', '2022-07-16 00:00:18'),
	(112, 18, 49, 0, 11295.08649787284, '2022-07-27 18:36:58', '2022-07-16 00:00:19'),
	(113, 36, 79, 0, 3201.493959, '2022-07-16 00:00:19', '2022-07-16 00:00:19'),
	(114, 18, 49, 0, 7471.090016136368, '2022-07-27 18:36:58', '2022-07-16 00:00:22'),
	(115, 17, 49, 0, 195508.88455985032, '2022-07-27 18:36:58', '2022-07-16 00:00:22'),
	(116, 17, 82, 0, 195563.31917141896, '2022-07-16 00:00:23', '2022-07-16 00:00:23'),
	(117, 17, 49, 0, 2602.3336504900003, '2022-07-27 18:36:58', '2022-07-16 00:00:25'),
	(118, 17, 49, 0, 195611.6596760023, '2022-07-27 18:36:58', '2022-07-16 00:00:26'),
	(119, 18, 49, 0, 23070.343530998634, '2022-07-27 18:36:58', '2022-07-16 00:00:27'),
	(120, 17, 49, 0, 2399.806399292273, '2022-07-27 18:36:58', '2022-07-16 00:00:27'),
	(121, 17, 82, 0, 195508.88455985032, '2022-07-16 00:00:28', '2022-07-16 00:00:28'),
	(122, 17, 82, 0, 195611.6596760023, '2022-07-16 00:00:32', '2022-07-16 00:00:32'),
	(123, 17, 49, 0, 1113.149594938684, '2022-07-27 18:36:58', '2022-07-16 00:00:36'),
	(124, 19, 49, 0, 8.5773212, '2022-07-27 18:36:58', '2022-07-16 00:00:39'),
	(125, 17, 49, 0, 1118.64156604, '2022-07-27 18:36:58', '2022-07-16 00:00:40'),
	(126, 19, 49, 0, 9.025704209487177, '2022-07-27 18:36:58', '2022-07-16 00:00:48'),
	(127, 20, 49, 0, 11230.377024761648, '2022-07-27 18:36:58', '2022-07-16 00:00:51'),
	(128, 20, 49, 0, 11248.33806474011, '2022-07-27 18:36:58', '2022-07-16 00:00:51'),
	(129, 20, 49, 0, 7421.332782733096, '2022-07-27 18:36:58', '2022-07-16 00:00:51'),
	(130, 18, 82, 0, 14.46578841448276, '2022-07-16 00:00:52', '2022-07-16 00:00:52'),
	(131, 18, 82, 0, 14.52091968478261, '2022-07-16 00:00:52', '2022-07-16 00:00:52'),
	(132, 17, 82, 0, 2602.3336504900003, '2022-07-16 00:00:53', '2022-07-16 00:00:53'),
	(133, 20, 49, 0, 7357.432446529992, '2022-07-27 18:36:58', '2022-07-16 00:00:55'),
	(134, 19, 49, 0, 188.99249283352944, '2022-07-27 18:36:58', '2022-07-16 00:00:57'),
	(135, 18, 82, 0, 3.1458952879487176, '2022-07-16 00:01:00', '2022-07-16 00:01:00'),
	(136, 20, 49, 0, 5.119899033030305, '2022-07-27 18:36:58', '2022-07-16 00:01:00'),
	(137, 17, 82, 0, 2399.806399292273, '2022-07-16 00:01:02', '2022-07-16 00:01:02'),
	(138, 19, 66, 0, 803.88, '2022-07-16 00:01:03', '2022-07-16 00:01:03'),
	(139, 18, 49, 0, 14.46578841448276, '2022-07-27 18:36:58', '2022-07-16 00:01:05'),
	(140, 19, 49, 0, 194.71738748, '2022-07-27 18:36:58', '2022-07-16 00:01:05'),
	(141, 20, 49, 0, 5.117622721891893, '2022-07-27 18:36:58', '2022-07-16 00:01:05'),
	(142, 18, 82, 0, 3.33835928125, '2022-07-16 00:01:06', '2022-07-16 00:01:06'),
	(143, 19, 66, 0, 8.5773212, '2022-07-16 00:01:07', '2022-07-16 00:01:07'),
	(144, 20, 49, 0, 264.72397234818186, '2022-07-27 18:36:58', '2022-07-16 00:01:08'),
	(145, 19, 66, 0, 9.025704209487177, '2022-07-16 00:01:09', '2022-07-16 00:01:09'),
	(146, 17, 82, 0, 1113.149594938684, '2022-07-16 00:01:09', '2022-07-16 00:01:09'),
	(147, 18, 49, 0, 14.52091968478261, '2022-07-27 18:36:58', '2022-07-16 00:01:11'),
	(148, 20, 49, 0, 274.7688982033333, '2022-07-27 18:36:58', '2022-07-16 00:01:13'),
	(149, 18, 49, 0, 3.1458952879487176, '2022-07-27 18:36:58', '2022-07-16 00:01:14'),
	(150, 18, 49, 0, 3.33835928125, '2022-07-27 18:36:58', '2022-07-16 00:01:14'),
	(151, 19, 66, 0, 188.99249283352944, '2022-07-16 00:01:17', '2022-07-16 00:01:17'),
	(152, 17, 82, 0, 1118.64156604, '2022-07-16 00:01:17', '2022-07-16 00:01:17'),
	(153, 19, 66, 0, 194.71738748, '2022-07-16 00:01:22', '2022-07-16 00:01:22'),
	(154, 17, 49, 0, 195956.02203691215, '2022-07-27 18:36:58', '2022-07-17 00:00:01'),
	(155, 17, 49, 0, 195563.31917141896, '2022-07-27 18:36:58', '2022-07-17 00:00:07'),
	(156, 18, 49, 0, 11292.047561971058, '2022-07-27 18:36:58', '2022-07-17 00:00:10'),
	(157, 17, 82, 0, 195956.02203691215, '2022-07-17 00:00:11', '2022-07-17 00:00:11'),
	(158, 17, 49, 0, 195508.88455985032, '2022-07-27 18:36:58', '2022-07-17 00:00:14'),
	(159, 17, 82, 0, 195563.31917141896, '2022-07-17 00:00:15', '2022-07-17 00:00:15'),
	(160, 18, 49, 0, 11295.08649787284, '2022-07-27 18:36:58', '2022-07-17 00:00:16'),
	(161, 17, 49, 0, 2602.3336504900003, '2022-07-27 18:36:58', '2022-07-17 00:00:17'),
	(162, 17, 49, 0, 195611.6596760023, '2022-07-27 18:36:58', '2022-07-17 00:00:22'),
	(163, 17, 82, 0, 195508.88455985032, '2022-07-17 00:00:22', '2022-07-17 00:00:22'),
	(164, 18, 49, 0, 7471.090016136368, '2022-07-27 18:36:58', '2022-07-17 00:00:24'),
	(165, 17, 49, 0, 2399.806399292273, '2022-07-27 18:36:58', '2022-07-17 00:00:25'),
	(166, 19, 66, 0, 803.88, '2022-07-17 00:00:29', '2022-07-17 00:00:29'),
	(167, 17, 82, 0, 195611.6596760023, '2022-07-17 00:00:29', '2022-07-17 00:00:29'),
	(168, 18, 49, 0, 23070.343530998634, '2022-07-27 18:36:58', '2022-07-17 00:00:32'),
	(169, 17, 49, 0, 1113.149594938684, '2022-07-27 18:36:58', '2022-07-17 00:00:33'),
	(170, 20, 49, 0, 11230.377024761648, '2022-07-27 18:36:58', '2022-07-17 00:00:33'),
	(171, 20, 49, 0, 11248.33806474011, '2022-07-27 18:36:58', '2022-07-17 00:00:33'),
	(172, 17, 49, 0, 1118.64156604, '2022-07-27 18:36:58', '2022-07-17 00:00:37'),
	(173, 36, 79, 0, 3201.493959, '2022-07-17 00:00:37', '2022-07-17 00:00:37'),
	(174, 20, 49, 0, 7421.332782733096, '2022-07-27 18:36:58', '2022-07-17 00:00:37'),
	(175, 20, 49, 0, 7357.432446529992, '2022-07-27 18:36:58', '2022-07-17 00:00:37'),
	(176, 19, 49, 0, 803.88, '2022-07-27 18:36:58', '2022-07-17 00:00:40'),
	(177, 19, 49, 0, 8.5773212, '2022-07-27 18:36:58', '2022-07-17 00:00:45'),
	(178, 18, 82, 0, 14.46578841448276, '2022-07-17 00:00:46', '2022-07-17 00:00:46'),
	(179, 20, 49, 0, 5.119899033030305, '2022-07-27 18:36:58', '2022-07-17 00:00:49'),
	(180, 19, 49, 0, 9.025704209487177, '2022-07-27 18:36:58', '2022-07-17 00:00:49'),
	(181, 18, 49, 0, 14.46578841448276, '2022-07-27 18:36:58', '2022-07-17 00:00:49'),
	(182, 18, 82, 0, 14.52091968478261, '2022-07-17 00:00:51', '2022-07-17 00:00:51'),
	(183, 19, 49, 0, 188.99249283352944, '2022-07-27 18:36:58', '2022-07-17 00:00:51'),
	(184, 17, 82, 0, 2602.3336504900003, '2022-07-17 00:00:55', '2022-07-17 00:00:55'),
	(185, 18, 82, 0, 11292.047561971058, '2022-07-17 00:00:55', '2022-07-17 00:00:55'),
	(186, 18, 49, 0, 14.52091968478261, '2022-07-27 18:36:58', '2022-07-17 00:00:55'),
	(187, 18, 49, 0, 3.1458952879487176, '2022-07-27 18:36:58', '2022-07-17 00:00:56'),
	(188, 20, 49, 0, 5.117622721891893, '2022-07-27 18:36:58', '2022-07-17 00:00:57'),
	(189, 18, 82, 0, 3.1458952879487176, '2022-07-17 00:00:58', '2022-07-17 00:00:58'),
	(190, 17, 82, 0, 2399.806399292273, '2022-07-17 00:00:59', '2022-07-17 00:00:59'),
	(191, 19, 49, 0, 194.71738748, '2022-07-27 18:36:58', '2022-07-17 00:00:59'),
	(192, 18, 49, 0, 3.33835928125, '2022-07-27 18:36:58', '2022-07-17 00:00:59'),
	(193, 18, 82, 0, 3.33835928125, '2022-07-17 00:01:00', '2022-07-17 00:01:00'),
	(194, 20, 49, 0, 264.72397234818186, '2022-07-27 18:36:58', '2022-07-17 00:01:01'),
	(195, 18, 82, 0, 11295.08649787284, '2022-07-17 00:01:01', '2022-07-17 00:01:01'),
	(196, 19, 66, 0, 8.5773212, '2022-07-17 00:01:02', '2022-07-17 00:01:02'),
	(197, 20, 49, 0, 274.7688982033333, '2022-07-27 18:36:58', '2022-07-17 00:01:03'),
	(198, 19, 66, 0, 9.025704209487177, '2022-07-17 00:01:04', '2022-07-17 00:01:04'),
	(199, 18, 82, 0, 7471.090016136368, '2022-07-17 00:01:05', '2022-07-17 00:01:05'),
	(200, 17, 82, 0, 1113.149594938684, '2022-07-17 00:01:07', '2022-07-17 00:01:07'),
	(201, 18, 82, 0, 23070.343530998634, '2022-07-17 00:01:08', '2022-07-17 00:01:08'),
	(202, 17, 82, 0, 1118.64156604, '2022-07-17 00:01:10', '2022-07-17 00:01:10'),
	(203, 19, 66, 0, 188.99249283352944, '2022-07-17 00:01:10', '2022-07-17 00:01:10'),
	(204, 19, 66, 0, 194.71738748, '2022-07-17 00:01:10', '2022-07-17 00:01:10'),
	(205, 19, 49, 0, 803.88, '2022-07-27 18:36:58', '2022-07-18 00:00:03'),
	(206, 17, 82, 0, 195956.02203691215, '2022-07-18 00:00:13', '2022-07-18 00:00:13'),
	(207, 18, 49, 0, 11292.047561971058, '2022-07-27 18:36:58', '2022-07-18 00:00:13'),
	(208, 18, 49, 0, 11295.08649787284, '2022-07-27 18:36:58', '2022-07-18 00:00:15'),
	(209, 17, 49, 0, 2602.3336504900003, '2022-07-27 18:36:58', '2022-07-18 00:00:16'),
	(210, 20, 49, 0, 11230.377024761648, '2022-07-27 18:36:58', '2022-07-18 00:00:17'),
	(211, 20, 49, 0, 11248.33806474011, '2022-07-27 18:36:58', '2022-07-18 00:00:17'),
	(212, 17, 82, 0, 195563.31917141896, '2022-07-18 00:00:20', '2022-07-18 00:00:20'),
	(213, 17, 49, 0, 2399.806399292273, '2022-07-27 18:36:58', '2022-07-18 00:00:20'),
	(214, 17, 82, 0, 195508.88455985032, '2022-07-18 00:00:22', '2022-07-18 00:00:22'),
	(215, 17, 82, 0, 195611.6596760023, '2022-07-18 00:00:24', '2022-07-18 00:00:24'),
	(216, 18, 49, 0, 7471.090016136368, '2022-07-27 18:36:58', '2022-07-18 00:00:24'),
	(217, 20, 49, 0, 7421.332782733096, '2022-07-27 18:36:58', '2022-07-18 00:00:26'),
	(218, 17, 49, 0, 1113.149594938684, '2022-07-27 18:36:58', '2022-07-18 00:00:26'),
	(219, 20, 49, 0, 7357.432446529992, '2022-07-27 18:36:58', '2022-07-18 00:00:28'),
	(220, 17, 49, 0, 1118.64156604, '2022-07-27 18:36:58', '2022-07-18 00:00:30'),
	(221, 18, 49, 0, 23070.343530998634, '2022-07-27 18:36:58', '2022-07-18 00:00:31'),
	(222, 18, 49, 0, 14.46578841448276, '2022-07-27 18:36:58', '2022-07-18 00:00:40'),
	(223, 18, 82, 0, 14.46578841448276, '2022-07-18 00:00:43', '2022-07-18 00:00:43'),
	(224, 20, 49, 0, 5.119899033030305, '2022-07-27 18:36:58', '2022-07-18 00:00:44'),
	(225, 19, 49, 0, 8.5773212, '2022-07-27 18:36:58', '2022-07-18 00:00:46'),
	(226, 18, 49, 0, 14.52091968478261, '2022-07-27 18:36:58', '2022-07-18 00:00:46'),
	(227, 18, 82, 0, 14.52091968478261, '2022-07-18 00:00:46', '2022-07-18 00:00:46'),
	(228, 36, 79, 0, 3201.493959, '2022-07-18 00:00:47', '2022-07-18 00:00:47'),
	(229, 18, 49, 0, 3.1458952879487176, '2022-07-27 18:36:58', '2022-07-18 00:00:48'),
	(230, 18, 82, 0, 3.1458952879487176, '2022-07-18 00:00:48', '2022-07-18 00:00:48'),
	(231, 18, 49, 0, 3.33835928125, '2022-07-27 18:36:58', '2022-07-18 00:00:49'),
	(232, 18, 82, 0, 3.33835928125, '2022-07-18 00:00:49', '2022-07-18 00:00:49'),
	(233, 17, 82, 0, 2602.3336504900003, '2022-07-18 00:00:53', '2022-07-18 00:00:53'),
	(234, 20, 49, 0, 5.117622721891893, '2022-07-27 18:36:58', '2022-07-18 00:00:53'),
	(235, 19, 66, 0, 8.5773212, '2022-07-18 00:00:54', '2022-07-18 00:00:54'),
	(236, 19, 49, 0, 9.025704209487177, '2022-07-27 18:36:58', '2022-07-18 00:00:54'),
	(237, 18, 82, 0, 11292.047561971058, '2022-07-18 00:00:57', '2022-07-18 00:00:57'),
	(238, 18, 82, 0, 11295.08649787284, '2022-07-18 00:00:57', '2022-07-18 00:00:57'),
	(239, 19, 66, 0, 9.025704209487177, '2022-07-18 00:00:58', '2022-07-18 00:00:58'),
	(240, 18, 82, 0, 7471.090016136368, '2022-07-18 00:00:58', '2022-07-18 00:00:58'),
	(241, 20, 49, 0, 264.72397234818186, '2022-07-27 18:36:58', '2022-07-18 00:00:58'),
	(242, 19, 66, 0, 803.88, '2022-07-18 00:00:58', '2022-07-18 00:00:58'),
	(243, 19, 49, 0, 188.99249283352944, '2022-07-27 18:36:58', '2022-07-18 00:01:00'),
	(244, 17, 82, 0, 2399.806399292273, '2022-07-18 00:01:01', '2022-07-18 00:01:01'),
	(245, 19, 66, 0, 188.99249283352944, '2022-07-18 00:01:02', '2022-07-18 00:01:02'),
	(246, 19, 49, 0, 194.71738748, '2022-07-27 18:36:58', '2022-07-18 00:01:02'),
	(247, 17, 82, 0, 1113.149594938684, '2022-07-18 00:01:05', '2022-07-18 00:01:05'),
	(248, 18, 82, 0, 23070.343530998634, '2022-07-18 00:01:05', '2022-07-18 00:01:05'),
	(249, 20, 49, 0, 274.7688982033333, '2022-07-27 18:36:58', '2022-07-18 00:01:06'),
	(250, 17, 49, 0, 195956.02203691215, '2022-07-27 18:36:58', '2022-07-18 00:01:06'),
	(251, 17, 49, 0, 195563.31917141896, '2022-07-27 18:36:58', '2022-07-18 00:01:06'),
	(252, 17, 49, 0, 195508.88455985032, '2022-07-27 18:36:58', '2022-07-18 00:01:10'),
	(253, 19, 66, 0, 194.71738748, '2022-07-18 00:01:11', '2022-07-18 00:01:11'),
	(254, 17, 82, 0, 1118.64156604, '2022-07-18 00:01:14', '2022-07-18 00:01:14'),
	(255, 17, 49, 0, 195611.6596760023, '2022-07-27 18:36:58', '2022-07-18 00:01:15');
/*!40000 ALTER TABLE `emission_board` ENABLE KEYS */;

-- 导出  表 srcode.emission_track 结构
CREATE TABLE IF NOT EXISTS `emission_track` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '租户号',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '名称',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '编号',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '描述',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态，0未发布;1已发布',
  `version` tinyint NOT NULL DEFAULT '0' COMMENT '版本',
  `start_at` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '起始运行时间',
  `created_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_code` (`code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=500000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='排放轨迹';

-- 正在导出表  srcode.emission_track 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `emission_track` DISABLE KEYS */;
INSERT INTO `emission_track` (`id`, `tenant_id`, `name`, `code`, `description`, `state`, `version`, `start_at`, `created_by`, `create_time`, `updated_by`, `update_time`) VALUES
	(49, 'defaultTenantId', '测试数据', 'TR5VLXBJC', '', 1, 0, '2020-01-01 00:00:00', 'defaultUserId', '2022-06-06 17:25:06', 'defaultUserId', '2022-07-27 18:36:58'),
	(56, 'defaultTenantId', '示例数据', 'T2MIFUTG2', '', 0, 0, '', 'defaultUserId', '2022-06-07 11:37:07', 'defaultUserId', '2022-07-27 18:19:32'),
	(66, 'defaultTenantId', '测试', 'TH7E7UUT4', '', 1, 0, '2022-01-01 00:00:00', 'defaultUserId', '2022-06-09 20:23:39', 'defaultUserId', '2022-06-09 21:37:21'),
	(79, 'defaultTenantId', '测试111', 'TZSJZJSHU', '', 1, 0, '2022-07-01 00:00:00', 'defaultUserId', '2022-07-08 09:57:08', 'defaultUserId', '2022-07-08 10:02:33'),
	(82, 'defaultTenantId', 'test', 'TH37GXAUF', '', 1, 0, '2011-07-12 17:46:36', 'defaultUserId', '2022-07-11 17:11:41', 'defaultUserId', '2022-07-11 17:46:44');
/*!40000 ALTER TABLE `emission_track` ENABLE KEYS */;

-- 导出  表 srcode.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL COMMENT '主键ID',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 正在导出表  srcode.user 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `name`, `age`, `email`) VALUES
	(1, '张三', 18, 'test1@baomidou.com'),
	(2, '李四', 20, 'test2@baomidou.com'),
	(3, '王五', 28, 'test3@baomidou.com'),
	(4, '赵六', 21, 'test4@baomidou.com'),
	(5, '杨洋', 24, 'test5@baomidou.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
