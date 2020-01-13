CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(127) COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `salt` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `goods_title` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `goods_img` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `goods_detail` varchar(255) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '',
  `goods_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `goods_stock` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `miaosha_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20) NOT NULL,
  `stock_count` int(11) NOT NULL,
  `start_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `end_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `miaosha_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `order_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `goods_id` bigint(20) NOT NULL,
  `delivery_addr_id` bigint(20) NOT NULL,
  `goods_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `goods_count` int(11) NOT NULL,
  `goods_price` decimal(10,2) NOT NULL,
  `status` int(11) NOT NULL,
  `order_channel` int(11) NOT NULL,
  `create_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `pay_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `fly-seckill-mall`.`goods` (`id`, `goods_name`, `goods_title`, `goods_img`, `goods_detail`, `goods_price`, `goods_stock`) VALUES ('1', '华为p30PRO手机金色', '华为p30PRO手机金色', '/static/img/iphone8.png', '华为p30PRO手机金色很好看奥，超划算啊哦', '5699.00', '10');
INSERT INTO `fly-seckill-mall`.`goods` (`id`, `goods_name`, `goods_title`, `goods_img`, `goods_detail`, `goods_price`, `goods_stock`) VALUES ('2', 'iphonex白色', 'iphonex白色', '/static/img/iphonex.png', 'iphonex白色', '6399.00', '10');


INSERT INTO `fly-seckill-mall`.`miaosha_goods` (`id`, `goods_id`, `stock_count`, `start_date`, `end_date`, `miaosha_price`) VALUES ('1', '1', '10', '2020-01-13 15:49:52', '2020-01-13 15:49:52', '1.00');
