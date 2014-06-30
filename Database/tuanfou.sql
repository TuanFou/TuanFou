/*
MySQL Data Transfer
Source Host: localhost
Source Database: tuanfou
Target Host: localhost
Target Database: tuanfou
Date: 2014/6/30 13:38:33
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_account
-- ----------------------------
DROP TABLE IF EXISTS `t_account`;
CREATE TABLE `t_account` (
  `id` int(11) NOT NULL auto_increment,
  `balance` float(11,0) default '0' COMMENT '余额',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL auto_increment,
  `employeeId` varchar(10) default NULL COMMENT '工职编号',
  `password` varchar(16) default NULL COMMENT '密码',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_area
-- ----------------------------
DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `id` int(11) NOT NULL auto_increment,
  `areaName` varchar(20) NOT NULL COMMENT '域区名',
  `cityId` int(11) NOT NULL COMMENT '所属城市id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_cinema
-- ----------------------------
DROP TABLE IF EXISTS `t_cinema`;
CREATE TABLE `t_cinema` (
  `id` int(11) NOT NULL auto_increment,
  `merchantId` int(11) NOT NULL,
  `name` varchar(20) NOT NULL COMMENT '影院名字',
  `phoneNumber` varchar(11) NOT NULL COMMENT '电话',
  `description` varchar(300) NOT NULL,
  `areaId` int(11) NOT NULL COMMENT '区域id',
  `address` varchar(100) NOT NULL COMMENT '影院详细地址',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_city
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `id` int(11) NOT NULL auto_increment,
  `cityName` varchar(20) NOT NULL COMMENT '城市名',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL auto_increment,
  `groupFilmId` int(11) NOT NULL COMMENT '团购电影id',
  `userId` int(11) NOT NULL COMMENT '会员id',
  `createTime` datetime NOT NULL COMMENT '论评时间',
  `content` varchar(200) NOT NULL COMMENT '评论内容',
  `star` int(11) default NULL COMMENT '星评,0,1,2,3,4,5',
  PRIMARY KEY  (`id`),
  KEY `groupFilmId` (`groupFilmId`),
  CONSTRAINT `groupFilmId` FOREIGN KEY (`groupFilmId`) REFERENCES `t_group_film` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_complaint
-- ----------------------------
DROP TABLE IF EXISTS `t_complaint`;
CREATE TABLE `t_complaint` (
  `id` int(11) NOT NULL auto_increment,
  `groupFilmId` int(11) NOT NULL COMMENT '投诉团购id',
  `userId` int(11) NOT NULL COMMENT '会员id',
  `reason` varchar(200) NOT NULL COMMENT '投诉原因',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_film
-- ----------------------------
DROP TABLE IF EXISTS `t_film`;
CREATE TABLE `t_film` (
  `id` int(11) NOT NULL auto_increment,
  `merchantId` int(11) default NULL COMMENT '商家id',
  `filmName` varchar(30) default NULL COMMENT '电影名称',
  `releaseDate` date default NULL COMMENT '映放日期',
  `version` varchar(10) default NULL COMMENT '版本',
  `country` varchar(20) default NULL COMMENT '地区，美国，中国，香港等等',
  `period` int(11) default NULL COMMENT '时长，分钟',
  `description` varchar(500) default NULL COMMENT '剧情介绍',
  `director` varchar(30) default NULL COMMENT '导演',
  `actors` varchar(100) default NULL COMMENT '演员',
  `star` int(11) default NULL COMMENT '星评，0,1,2,3,4,5',
  `status` int(1) NOT NULL COMMENT '状态 0：审核中 1：审核通过 2：审核未通过',
  `applicateTime` timestamp NULL default NULL COMMENT '申请时间',
  `auditResult` int(1) default NULL COMMENT '审核状态  1：审核通过 2：审核未通过',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_film_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_film_tag`;
CREATE TABLE `t_film_tag` (
  `id` int(11) NOT NULL auto_increment,
  `filmId` int(11) NOT NULL COMMENT '影电id',
  `tagId` int(11) NOT NULL COMMENT '签标id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_group_film
-- ----------------------------
DROP TABLE IF EXISTS `t_group_film`;
CREATE TABLE `t_group_film` (
  `id` int(11) NOT NULL auto_increment,
  `filmId` int(11) NOT NULL COMMENT '电影id',
  `areaId` int(11) NOT NULL COMMENT '区域id',
  `cinemaId` int(11) NOT NULL COMMENT '电影院id',
  `currentPrice` float NOT NULL COMMENT '折后打价格',
  `originalPrice` float NOT NULL COMMENT '始原价格',
  `startDate` datetime default NULL COMMENT '有效期开始时间',
  `endDate` datetime default NULL COMMENT '有效期结束时间',
  `status` int(11) NOT NULL COMMENT '0:申请中，1：已上架，2：已下架',
  `remark` varchar(300) default NULL COMMENT '备注',
  `type` int(11) NOT NULL COMMENT '电影类型，0：已经上映，1：即将上映 2：下架',
  `picUrl` varchar(300) default './imgs/1.png',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_heart
-- ----------------------------
DROP TABLE IF EXISTS `t_heart`;
CREATE TABLE `t_heart` (
  `id` int(11) NOT NULL auto_increment,
  `groupFilmId` int(11) default NULL COMMENT '购团电影id',
  `userId` int(11) default NULL COMMENT '会员id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_merchant
-- ----------------------------
DROP TABLE IF EXISTS `t_merchant`;
CREATE TABLE `t_merchant` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL COMMENT '商家姓名',
  `password` varchar(16) NOT NULL COMMENT '码密',
  `idNumber` varchar(18) NOT NULL COMMENT '身份证号',
  `photoUrl` varchar(300) NOT NULL COMMENT '照片路径',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `id` int(11) NOT NULL auto_increment,
  `senderId` int(11) default NULL COMMENT '信发人id',
  `receiverId` int(11) default NULL COMMENT '收信人id',
  `content` varchar(300) default NULL COMMENT '内容',
  `time` datetime default NULL COMMENT '时间',
  `type` int(11) default NULL COMMENT '0:理员管-商家  1:管理员-会员 2：会员-会员',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL auto_increment,
  `groupFilmId` int(11) default NULL COMMENT '团购电影id',
  `userId` int(11) default NULL,
  `createTime` datetime default NULL COMMENT '订单日期',
  `expiredTime` datetime default NULL COMMENT '效时间失，超过40分为付款即为失效',
  `status` int(11) default NULL COMMENT '订单状态,0：失效，1：未支付，2：已经支付',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int(11) NOT NULL auto_increment,
  `tagName` varchar(4) NOT NULL COMMENT '标签名称',
  `filmNum` int(11) NOT NULL COMMENT '拥有该标签的电影数量',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL auto_increment COMMENT '员会id',
  `accountId` int(11) NOT NULL COMMENT '户账id',
  `username` char(30) NOT NULL COMMENT '用户名',
  `password` char(20) NOT NULL COMMENT '密码',
  `email` char(80) default NULL COMMENT '邮箱',
  `cityId` int(11) NOT NULL,
  `description` varchar(500) default NULL COMMENT '简介',
  `photoUrl` varchar(300) default NULL COMMENT '头像图片路径',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_account` VALUES ('1', '10');
INSERT INTO `t_account` VALUES ('2', '12');
INSERT INTO `t_account` VALUES ('3', '10');
INSERT INTO `t_account` VALUES ('4', '10');
INSERT INTO `t_account` VALUES ('5', '10');
INSERT INTO `t_area` VALUES ('1', '洪山区', '2');
INSERT INTO `t_area` VALUES ('2', '武昌区', '2');
INSERT INTO `t_area` VALUES ('3', '海淀区', '7');
INSERT INTO `t_area` VALUES ('4', '中关村', '7');
INSERT INTO `t_area` VALUES ('5', '卫东区', '6');
INSERT INTO `t_area` VALUES ('6', '西岗区', '6');
INSERT INTO `t_cinema` VALUES ('1', '1', '天河剧院', '13387166727', '环境优美，免费wifi', '1', '光谷步行街');
INSERT INTO `t_cinema` VALUES ('2', '2', 'UC影院', '12345678908', '环境优美，免费wifi', '2', '汉口步行街');
INSERT INTO `t_cinema` VALUES ('3', '3', '灿灿大剧场', '777899943', '环境优美，免费wifi', '1', '关山大道');
INSERT INTO `t_city` VALUES ('2', '武汉');
INSERT INTO `t_city` VALUES ('6', '大连');
INSERT INTO `t_city` VALUES ('7', '北京');
INSERT INTO `t_city` VALUES ('8', '??');
INSERT INTO `t_comment` VALUES ('1', '1', '1', '2014-06-28 13:02:15', '不错额', '4');
INSERT INTO `t_comment` VALUES ('2', '1', '1', '2014-06-28 00:00:00', '?????sb', '2');
INSERT INTO `t_comment` VALUES ('3', '1', '1', '2014-06-28 00:00:00', '?????sb', '2');
INSERT INTO `t_complaint` VALUES ('1', '1', '1', '不好看');
INSERT INTO `t_film` VALUES ('1', '1', '变形金刚', '2014-06-27', '四', '美国', '150', '机器人大战', '马克·沃尔伯格', '斯坦利突起', '4', '1', '2014-06-28 23:44:26', '1');
INSERT INTO `t_film` VALUES ('2', '1', '沉睡的魔谷', '2014-06-28', 'Chinese', 'America', '120', 'this is a splendid action film', 'siperberg', '???', '5', '0', '2014-06-20 00:00:56', '0');
INSERT INTO `t_film_tag` VALUES ('1', '1', '3');
INSERT INTO `t_film_tag` VALUES ('2', '2', '2');
INSERT INTO `t_film_tag` VALUES ('3', '1', '2');
INSERT INTO `t_group_film` VALUES ('1', '1', '1', '1', '19.99', '25', '2014-06-28 12:59:52', '2014-07-05 13:00:10', '1', '不错的电影', '0', './imgs/1.png');
INSERT INTO `t_group_film` VALUES ('2', '2', '1', '1', '29.8', '20', '2014-06-28 00:00:00', '2014-06-28 00:00:00', '0', 'hello', '0', './imgs/1.png');
INSERT INTO `t_heart` VALUES ('1', '1', '1');
INSERT INTO `t_merchant` VALUES ('1', '孔德飞', '123456', '41048219920213671X', 'default.jpg');
INSERT INTO `t_merchant` VALUES ('2', '赖楠', '123456', '410488199408261111', 'default.jpg');
INSERT INTO `t_merchant` VALUES ('3', '黄灿圳', '123456', '123456789012342222', 'default.jpg');
INSERT INTO `t_message` VALUES ('1', '1', '1', 'hello,i am kdf', '2014-06-28 13:01:18', '1');
INSERT INTO `t_order` VALUES ('1', '1', '1', '2014-06-28 13:01:33', '2014-06-28 20:01:36', '1');
INSERT INTO `t_tag` VALUES ('1', '爱情', '0');
INSERT INTO `t_tag` VALUES ('2', '动作', '0');
INSERT INTO `t_tag` VALUES ('3', '科幻', '1');
INSERT INTO `t_tag` VALUES ('4', '惊悚', '0');
INSERT INTO `t_user` VALUES ('1', '1', 'kdf', '123', 'kdf@163.com', '2', 'hello', 'kdf.jpg');
INSERT INTO `t_user` VALUES ('2', '2', 'kongdefei', '123', 'kdf5000@163.com', '6', 'hello', 'photo.jpg');
INSERT INTO `t_user` VALUES ('3', '3', 'kdf5000', '123', 'kdf@163.com', '7', 'hello', 'kdf.jpg');
INSERT INTO `t_user` VALUES ('4', '4', 'kdf5000', '123', 'kdf@163.com', '2', 'hello', 'kdf.jpg');
INSERT INTO `t_user` VALUES ('5', '5', 'kongdefei5000', '123', 'kdf@163.com', '2', 'hello', 'kdf.jpg');
