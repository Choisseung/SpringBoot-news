-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1:3306
-- 生成日期： 2020-08-04 10:07:13
-- 服务器版本： 10.3.14-MariaDB
-- PHP 版本： 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `phones`
--

-- --------------------------------------------------------

--
-- 表的结构 `m_order`
--

DROP TABLE IF EXISTS `m_order`;
CREATE TABLE IF NOT EXISTS `m_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sum_price` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `m_order`
--

INSERT INTO `m_order` (`id`, `amount`, `create_time`, `product_id`, `user_id`, `img`, `name`, `sum_price`) VALUES
(8, '3', '2020-08-04 14:32:28', 25, 1, 'https://img14.360buyimg.com/n0/jfs/t1/41566/13/14792/149059/5d7809a7E99b4ed1b/56ea66c5f8a6f724.jpg', 'iPhone 11', '17697.0'),
(11, '2', '2020-08-04 14:41:44', 45, 1, 'https://img14.360buyimg.com/n0/jfs/t1/89063/4/13763/58243/5e5e1252E7cdda145/fe865faab54c33b7.jpg', 'Galaxy S20 Ultra 5G', '21156.0'),
(17, '1', '2020-08-04 14:57:59', 3, 1, 'https://img14.360buyimg.com/n0/jfs/t1/91087/36/12227/66469/5e44f450E4a424f4e/7d23ad95ca25f0b4.jpg', '小米10', '3999.0'),
(18, '7', '2020-08-04 15:05:06', 34, 1, 'https://img14.360buyimg.com/n0/jfs/t1/45124/13/10457/96407/5d780a64Ef57cfbc1/61f65ac6aae3146b.jpg', 'iPad  2019 10.2', '20083.0'),
(19, '9', '2020-08-04 15:07:38', 46, 1, 'https://img14.360buyimg.com/n0/jfs/t1/88864/32/13149/33087/5e5e129dE273d257b/fb4c4d66c4cfb1dd.jpg', 'Galaxy S20 Ultra 5G', '100791.0'),
(20, '1', '2020-08-04 15:43:53', 20, 1, 'https://img14.360buyimg.com/n0/jfs/t1/137690/39/4313/601699/5f251d06E5e83428f/486faa00aa372622.png', '荣耀X10', '2149.0'),
(21, '11', '2020-08-04 15:10:21', 52, 1, 'https://img14.360buyimg.com/n0/jfs/t1/119350/35/5337/163613/5eb3b7bdE176ca4f5/268b430a16b99fc8.jpg', '魅族17 Pro', '51689.0'),
(22, '2', '2020-08-04 16:10:43', 23, 2, 'https://img14.360buyimg.com/n0/jfs/t1/104206/32/178/468711/5da83929E4ac45fd7/96e5c3d697eed20d.jpg', 'HUAWEI 畅享10', '1918.0');

-- --------------------------------------------------------

--
-- 表的结构 `m_product`
--

DROP TABLE IF EXISTS `m_product`;
CREATE TABLE IF NOT EXISTS `m_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` int(11) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `p_model` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `product_img` varchar(255) DEFAULT NULL,
  `productname` varchar(255) DEFAULT NULL,
  `sales_volume` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `vendor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `m_product`
--

INSERT INTO `m_product` (`id`, `amount`, `brand`, `color`, `p_model`, `price`, `product_img`, `productname`, `sales_volume`, `type`, `update_time`, `vendor`) VALUES
(1, 99, '小米', '白色', '小米10Pro', '4999', 'https://img14.360buyimg.com/n0/jfs/t1/101657/4/19179/137400/5e9ade96E47d86e71/0cf6e05c9b7d4360.jpg', '小米10Pro', 0, '手机', '2019-08-03 00:15:00', '2'),
(2, 99, '小米', '星空蓝', '小米10Pro', '4999', 'https://img14.360buyimg.com/n0/jfs/t1/105060/20/11997/72376/5e43ffbaE92101e04/5c224a6977b6da43.jpg', '小米10Pro', 0, '手机', '2019-08-04 00:15:00', '2'),
(3, 98, '小米', '钛银黑', '小米10', '3999', 'https://img14.360buyimg.com/n0/jfs/t1/91087/36/12227/66469/5e44f450E4a424f4e/7d23ad95ca25f0b4.jpg', '小米10', 1, '手机', '2020-08-04 15:08:48', '2'),
(4, 99, '小米', '冰海蓝', '小米10', '3999', 'https://img14.360buyimg.com/n0/jfs/t1/86361/7/11985/71392/5e44016fE428a0d07/2cc211413b7f3a5e.jpg', '小米10', 0, '手机', '2019-08-06 00:15:00', '2'),
(5, 99, '小米', '蜜桃金', '小米10', '3999', 'https://img14.360buyimg.com/n0/jfs/t1/97161/40/12127/66234/5e440190E7cd0f54e/33627b2c39a67241.jpg', '小米10', 0, '手机', '2019-08-07 00:15:00', '2'),
(6, 99, '小米', '国风雅灰', '小米10', '3999', 'https://img14.360buyimg.com/n0/jfs/t1/140484/20/3978/93663/5f223172E5c52b721/17a22d63fccb4782.jpg', '小米10', 0, '手机', '2019-08-08 00:15:00', '2'),
(7, 99, '红米', '深海微光', 'Redmi K30', '1349', 'https://img14.360buyimg.com/n0/jfs/t1/106720/5/6864/102152/5df64dd3E54ef6db2/17cc73b43ad6538d.jpg', 'Redmi K30', 0, '手机', '2019-08-09 00:15:00', '2'),
(8, 99, '红米', '紫玉幻境', 'Redmi K30', '1349', 'https://img14.360buyimg.com/n0/jfs/t1/92595/13/5590/90517/5dee4a12Ef3d605c9/f5e1a764e2632674.jpg', 'Redmi K30', 0, '手机', '2019-08-10 00:15:00', '2'),
(9, 99, '红米', '花影惊鸿', 'Redmi K30', '1349', 'https://img14.360buyimg.com/n0/jfs/t1/101650/38/5462/106961/5dee4c74E9b771245/77b2ce4a20e19c14.jpg', 'Redmi K30', 0, '手机', '2019-08-11 00:15:00', '2'),
(10, 99, '红米', '深海蓝', 'Redmi 10X', '1799', 'https://img14.360buyimg.com/n0/jfs/t1/117983/29/8108/89342/5ecbbf8eEf1103a18/8bc36e84ae221109.jpg', 'Redmi 10X', 0, '手机', '2019-08-12 00:15:00', '2'),
(11, 99, '红米', '星露白', 'Redmi 10X', '1799', 'https://img14.360buyimg.com/n0/jfs/t1/135842/4/326/72866/5ecbc012E8aea5700/2edd97fddf7cb354.jpg', 'Redmi 10X', 0, '手机', '2019-08-13 00:15:00', '2'),
(12, 99, '华为', '亮黑', '华为 HUAWEI P30 Pro', '3488', 'https://img14.360buyimg.com/n0/jfs/t1/25813/29/12657/304911/5c98c8e2E6bcf7d2d/25342f237b56fe97.jpg', '华为 HUAWEI P30 Pro', 0, '手机', '2019-08-14 00:15:00', '1'),
(13, 99, '华为', '天空之境', '华为 HUAWEI P30 Pro', '3488', 'https://img14.360buyimg.com/n0/jfs/t1/31698/11/11865/218814/5cb68870Ebf26e1bd/dbe080c29fb0aeff.jpg', '华为 HUAWEI P30 Pro', 0, '手机', '2019-08-15 00:15:00', '1'),
(14, 99, '华为', '极光色', '华为 HUAWEI P30 Pro', '3488', 'https://img14.360buyimg.com/n0/jfs/t1/49447/4/8661/108065/5d5fcc27E863576b5/1278d7f214ba0e4d.jpg', '华为 HUAWEI P30 Pro', 0, '手机', '2019-08-16 00:15:00', '1'),
(15, 99, '华为', '幻夜黑', '华为 HUAWEI nova 5i', '1499', 'https://img14.360buyimg.com/n0/jfs/t1/75571/15/2424/105563/5d0b4e04E83642af1/ba7b689fe26ddc84.jpg', '华为 HUAWEI nova 5i', 0, '手机', '2019-08-17 00:15:00', '1'),
(16, 99, '华为', '星河银', '华为 HUAWEI Mate 30', '3599', 'https://img14.360buyimg.com/n0/jfs/t1/75416/3/11548/695450/5d901d3fEdaaa21fa/88771c48f6f46005.jpg', '华为 HUAWEI Mate 30', 0, '手机', '2019-08-18 00:15:00', '1'),
(17, 99, '荣耀', '冰岛幻境', '荣耀Play4T Pro', '1399', 'https://img14.360buyimg.com/n0/jfs/t1/104812/35/17303/242507/5e848fb1E2c1d6eff/d2db1412dcce1d96.jpg', '荣耀Play4T Pro', 0, '手机', '2019-08-19 00:15:00', '1'),
(18, 99, '荣耀', '钛空银', '荣耀30 Pro', '3999', 'https://img14.360buyimg.com/n0/jfs/t1/114121/31/1226/152024/5e95e4edE3b1b4669/cb2bead63ba8d643.jpg', '荣耀30 Pro', 0, '手机', '2019-08-20 00:15:00', '1'),
(19, 99, '荣耀', '蝶羽白', '荣耀30S', '2399', 'https://img14.360buyimg.com/n0/jfs/t1/114717/38/6659/123673/5ebbd177Ed621712b/ccfec8fb9de3c859.jpg', '荣耀30S', 0, '手机', '2019-08-21 00:15:00', '1'),
(20, 98, '荣耀', '竞速蓝', '荣耀X10', '2149', 'https://img14.360buyimg.com/n0/jfs/t1/137690/39/4313/601699/5f251d06E5e83428f/486faa00aa372622.png', '荣耀X10', 1, '手机', '2020-08-04 15:43:53', '1'),
(21, 99, '麦芒', '幻夜黑', '华为麦芒9', '2199', 'https://img14.360buyimg.com/n0/jfs/t1/146696/13/3898/437113/5f1e98deE0f96e1de/5742b881d8d7f10b.png', '华为麦芒9', 0, '手机', '2019-08-23 00:15:00', '1'),
(22, 99, '麦芒', '幻夜黑', '麦芒8', '1288', 'https://img14.360buyimg.com/n0/jfs/t1/56111/23/5336/441045/5d2ee49dEddce8063/eb584a52aa0840e7.png', '麦芒8', 0, '手机', '2019-08-24 00:15:00', '1'),
(23, 97, '畅享', '极光蓝', 'HUAWEI 畅享10', '959', 'https://img14.360buyimg.com/n0/jfs/t1/104206/32/178/468711/5da83929E4ac45fd7/96e5c3d697eed20d.jpg', 'HUAWEI 畅享10', 2, '手机', '2020-08-04 16:10:43', '1'),
(24, 99, '苹果', '白色', 'iPhone 11', '5899', 'https://img14.360buyimg.com/n0/jfs/t1/52252/35/10516/124064/5d7808e0E46202391/7100f3733a1c1f00.jpg', 'iPhone 11', 0, '手机', '2019-08-26 00:15:00', '3'),
(25, 99, '苹果', '绿色', 'iPhone 11', '5899', 'https://img14.360buyimg.com/n0/jfs/t1/41566/13/14792/149059/5d7809a7E99b4ed1b/56ea66c5f8a6f724.jpg', 'iPhone 11', 0, '手机', '2019-08-27 00:15:00', '3'),
(26, 99, '苹果', '暗夜绿色', 'iPhone 11 Pro Max', '10899', 'https://img14.360buyimg.com/n0/jfs/t1/51521/12/10437/169738/5d780c40Eda0f0e1d/ccbc7745b343f87d.jpg', 'iPhone 11 Pro Max', 0, '手机', '2019-08-28 00:15:00', '3'),
(27, 99, '苹果', '金色', 'iPhone 11 Pro Max', '10899', 'https://img14.360buyimg.com/n0/jfs/t1/72651/28/9824/200586/5d780cf6Efb1a92fc/b9958af5d7d7602f.jpg', 'iPhone 11 Pro Max', 0, '手机', '2019-08-29 00:15:00', '3'),
(28, 99, '苹果', '蓝色', 'iPhone XR', '4699', 'https://img14.360buyimg.com/n0/jfs/t1/2267/5/3518/83121/5b997bf1E6409d7b2/378263542aab44a0.jpg', 'iPhone XR', 0, '手机', '2019-08-30 00:15:00', '3'),
(29, 99, '苹果', '白色', 'iPhone XR', '4699', 'https://img14.360buyimg.com/n0/jfs/t1/1695/39/3482/70556/5b997bf7Ed2d65519/749d8efdff062fb0.jpg', 'iPhone XR', 0, '手机', '2019-08-31 00:15:00', '3'),
(30, 99, '苹果', '银色', 'iPhone XS Max', '6099', 'https://img14.360buyimg.com/n0/jfs/t1/4609/37/3522/134740/5b997beeE4750d52c/c13c9b603ff5083d.jpg', 'iPhone XS Max', 0, '手机', '2019-09-01 00:15:00', '3'),
(31, 99, '苹果', '银色', 'iPad Air 3', '4799', 'https://img14.360buyimg.com/n0/jfs/t1/11439/7/12311/192448/5c9087c3E8bdd20e8/d800e2b7afa7724f.jpg', 'iPad Air 3', 0, '平板', '2019-09-02 00:15:00', '3'),
(32, 99, '苹果', '深空灰色', 'iPad Air 3', '4799', 'https://img14.360buyimg.com/n0/jfs/t1/62619/25/14946/192739/5dc54d39Efa435244/6ad261499ed47831.jpg', 'iPad Air 3', 0, '平板', '2019-09-03 00:15:00', '3'),
(33, 99, '苹果', '深空灰色', 'iPad Pro 11', '7029', 'https://img14.360buyimg.com/n0/jfs/t1/93232/3/15628/251953/5e723c47E54d3aff9/9d083eaea3409b83.jpg', 'iPad Pro 11', 0, '平板', '2019-09-04 00:15:00', '3'),
(34, 99, '苹果', '金色', 'iPad  2019 10.2', '2869', 'https://img14.360buyimg.com/n0/jfs/t1/45124/13/10457/96407/5d780a64Ef57cfbc1/61f65ac6aae3146b.jpg', 'iPad  2019 10.2', 0, '平板', '2019-09-05 00:15:00', '3'),
(35, 99, '苹果', '银色', 'iPad mini 5', '2849', 'https://img14.360buyimg.com/n0/jfs/t1/16095/31/11571/118007/5c9065a6Ed94fd377/20640a59bf8dc661.jpg', 'iPad mini 5', 0, '平板', '2019-09-06 00:15:00', '3'),
(36, 99, '三星', '迷雾金', 'Galaxy Z Flip 5G', '12499', 'https://img14.360buyimg.com/n0/jfs/t1/140251/21/3669/45395/5f18ff99E01f0401e/85e0e39be131f0de.jpg', 'Galaxy Z Flip 5G', 0, '手机', '2019-09-07 00:15:00', '4'),
(37, 99, '三星', '皓玉白', 'Galaxy S10', '3499', 'https://img14.360buyimg.com/n0/jfs/t1/40269/5/14761/192059/5d5b615fE08973f49/d9418330ab754826.jpg', 'Galaxy S10', 0, '手机', '2019-09-08 00:15:00', '4'),
(38, 99, '三星', '白色', 'Galaxy Note10', '4199', 'https://img14.360buyimg.com/n0/jfs/t1/88636/37/2294/198759/5dcd1ed0Ea2c619d9/5c58d1ee342e7bb4.jpg', 'Galaxy Note10', 0, '手机', '2019-09-09 00:15:00', '4'),
(39, 99, '三星', '睿金', '三星W2019', '14788', 'https://img14.360buyimg.com/n0/jfs/t1/107596/31/7853/117600/5e60c3d4Ee3ea7d04/b9c76bddd08a217e.jpg', '三星W2019', 0, '手机', '2019-09-10 00:15:00', '4'),
(40, 99, '三星', '至尊', '三星 W20 5G', '15778', 'https://img14.360buyimg.com/n0/jfs/t1/95951/33/4417/45848/5de74e60Ea37b1fbf/fcae8b50be0385b6.jpg', '三星 W20 5G', 0, '手机', '2019-09-11 00:15:00', '4'),
(41, 99, '三星', '切割蓝', 'Galaxy A71', '3099', 'https://img14.360buyimg.com/n0/jfs/t1/101014/38/19377/105895/5e9e4afaE30c7c8b9/56e46d80ad5ffb83.jpg', 'Galaxy A71', 0, '手机', '2019-09-12 00:15:00', '4'),
(42, 99, '三星', '莫奈彩', 'Galaxy Note10+5G', '5769', 'https://img14.360buyimg.com/n0/jfs/t1/134494/17/3/91839/5ec774efEe1882b05/b1050b57dacfb258.jpg', 'Galaxy Note10+5G', 0, '手机', '2019-09-13 00:15:00', '4'),
(43, 99, '三星', '麦昆黑', 'Galaxy Note10+5G', '5769', 'https://img14.360buyimg.com/n0/jfs/t1/42658/4/12529/86522/5d5d38eeE23f6fe5e/f88ad5a264f4b909.jpg', 'Galaxy Note10+5G', 0, '手机', '2019-09-14 00:15:00', '4'),
(44, 99, '三星', '黑色', '三星G9298', '4688', 'https://img14.360buyimg.com/n0/jfs/t1/29866/31/15729/207960/5cb2f25fEe440abd3/054848284d5050eb.png', '三星G9298', 0, '手机', '2019-09-15 00:15:00', '4'),
(45, 99, '三星', '遐想灰', 'Galaxy S20 Ultra 5G', '10578', 'https://img14.360buyimg.com/n0/jfs/t1/89063/4/13763/58243/5e5e1252E7cdda145/fe865faab54c33b7.jpg', 'Galaxy S20 Ultra 5G', 0, '手机', '2019-09-16 00:15:00', '4'),
(46, 98, '三星', '幻游黑', 'Galaxy S20 Ultra 5G', '11199', 'https://img14.360buyimg.com/n0/jfs/t1/88864/32/13149/33087/5e5e129dE273d257b/fb4c4d66c4cfb1dd.jpg', 'Galaxy S20 Ultra 5G', 1, '手机', '2020-08-04 15:07:38', '4'),
(47, 99, '魅族', '十七度灰', '魅族17', '3699', 'https://img14.360buyimg.com/n0/jfs/t1/121150/33/8284/68362/5f22f0a4Eee68fcd2/51cd7445e9429892.jpg', '魅族17', 0, '手机', '2019-09-18 00:15:00', '5'),
(48, 99, '魅族', '松深入墨', '魅族17', '3699', 'https://img14.360buyimg.com/n0/jfs/t1/124452/32/8714/77603/5f278bcfEb2f32bbd/0d6358aa9cae032a.jpg', '魅族17', 0, '手机', '2019-09-19 00:15:00', '5'),
(49, 99, '魅族', '梦幻独角兽', '魅族17', '3699', 'https://img14.360buyimg.com/n0/jfs/t1/135821/23/2709/206234/5eee2f73E082b8d23/a9d7992529e411b8.jpg', '魅族17', 0, '手机', '2019-09-20 00:15:00', '5'),
(50, 99, '魅族', '月白天青', '魅族17 Pro', '4699', 'https://img14.360buyimg.com/n0/jfs/t1/113825/26/12149/166298/5f0c0b39Ec1b8370b/6e5aa2210ba57712.jpg', '魅族17 Pro', 0, '手机', '2019-09-21 00:15:00', '5'),
(51, 99, '魅族', '乌金', '魅族17 Pro', '4699', 'https://img14.360buyimg.com/n0/jfs/t1/114037/35/13461/52919/5f22f189E75eaa8bf/72471f5430611933.jpg', '魅族17 Pro', 0, '手机', '2019-09-22 00:15:00', '5'),
(52, 88, '魅族', '定白', '魅族17 Pro', '4699', 'https://img14.360buyimg.com/n0/jfs/t1/119350/35/5337/163613/5eb3b7bdE176ca4f5/268b430a16b99fc8.jpg', '魅族17 Pro', 11, '手机', '2020-08-04 15:10:21', '5'),
(53, 99, '魅族', '日光橙', '魅族16T', '2299', 'https://img14.360buyimg.com/n0/jfs/t1/100765/24/10905/221245/5e2038caEcdbe3240/b9417e22872e3844.jpg', '魅族16T', 0, '手机', '2019-09-24 00:15:00', '5'),
(54, 99, '魅族', '湖光绿', '魅族16T', '2299', 'https://img14.360buyimg.com/n0/jfs/t1/97219/40/10900/224318/5e20486dE6a8e920b/85cb8585c93378aa.jpg', '魅族16T', 0, '手机', '2019-09-25 00:15:00', '5'),
(55, 99, '魅族', '珊瑚橙', '魅族16Xs', '1499', 'https://img14.360buyimg.com/n0/jfs/t1/90707/26/2026/86395/5dca1204Eee1d78a9/17a56d1a21c10770.jpg', '魅族16Xs', 0, '手机', '2019-09-26 00:15:00', '5'),
(56, 99, '魅族', '骑士黑', '魅族16Xs', '1499', 'https://img14.360buyimg.com/n0/jfs/t1/72471/10/15154/77607/5dca11ceEc6f0d0f1/77834412603791a4.jpg', '魅族16Xs', 0, '手机', '2019-09-27 00:15:00', '5'),
(57, 99, 'ipad', '深空灰色 ', 'iPad2018 9.7', '2818', 'https://img14.360buyimg.com/n0/jfs/t1/124297/21/8265/155842/5f20d84cE5419dfd4/407fb1265640312a.jpg', 'iPad2018 9.7', 0, '平板', '2020-08-04 09:58:51', '3');

-- --------------------------------------------------------

--
-- 表的结构 `m_trolley`
--

DROP TABLE IF EXISTS `m_trolley`;
CREATE TABLE IF NOT EXISTS `m_trolley` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `m_trolley`
--

INSERT INTO `m_trolley` (`id`, `product_id`, `user_id`) VALUES
(1, 3, 1),
(2, 34, 1),
(3, 23, 2),
(4, 12, 2),
(5, 25, 1),
(6, 54, 1),
(7, 54, 1),
(8, 54, 1),
(9, 54, 1),
(10, 54, 1),
(11, 54, 1),
(12, 53, 1),
(13, 53, 2),
(14, 53, 1),
(15, 46, 1),
(16, 45, 1),
(17, 20, 1),
(18, 55, 1),
(19, 52, 1),
(20, 52, 2);

-- --------------------------------------------------------

--
-- 表的结构 `m_user`
--

DROP TABLE IF EXISTS `m_user`;
CREATE TABLE IF NOT EXISTS `m_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin` bit(1) NOT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `m_user`
--

INSERT INTO `m_user` (`id`, `admin`, `img_url`, `nickname`, `password`, `phone`, `username`) VALUES
(1, b'1', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=137628589,3436980029&fm=26&gp=0.jpg', 'tengshan1', '1', '1212121212', '147258'),
(2, b'0', 'https://img14.360buyimg.com/n0/jfs/t1/93232/3/15628/251953/5e723c47E54d3aff9/9d083eaea3409b83.jpg', '我不是管理员嗷', '147258', '1555555555', '123456');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
