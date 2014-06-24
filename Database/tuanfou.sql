/*
MySQL Data Transfer
Source Host: localhost
Source Database: tuanfou
Target Host: localhost
Target Database: tuanfou
Date: 2014/6/24 23:18:51
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL auto_increment,
  `employeeId` varchar(10) default NULL COMMENT '工职编号',
  `password` varchar(16) default NULL COMMENT '密码',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_area
-- ----------------------------
DROP TABLE IF EXISTS `t_area`;
CREATE TABLE `t_area` (
  `id` int(11) NOT NULL,
  `areaName` varchar(20) NOT NULL COMMENT '域区名',
  `cityId` int(11) NOT NULL COMMENT '所属城市id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_cinema
-- ----------------------------
DROP TABLE IF EXISTS `t_cinema`;
CREATE TABLE `t_cinema` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL COMMENT '影院名字',
  `phoneNumber` varchar(11) default NULL COMMENT '电话',
  `description` varchar(300) NOT NULL,
  `cityId` int(11) NOT NULL COMMENT '所属城市id',
  `areaId` int(11) NOT NULL COMMENT '区域id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_city
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `id` int(11) NOT NULL auto_increment,
  `cityName` varchar(20) NOT NULL COMMENT '城市名',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL auto_increment,
  `filmId` int(11) NOT NULL COMMENT '团购电影id',
  `userId` int(11) NOT NULL COMMENT '会员id',
  `createTime` datetime NOT NULL COMMENT '论评时间',
  `content` varchar(200) NOT NULL COMMENT '评论内容',
  `star` int(11) default NULL COMMENT '星评,0,1,2,3,4,5',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_complaint
-- ----------------------------
DROP TABLE IF EXISTS `t_complaint`;
CREATE TABLE `t_complaint` (
  `id` int(11) default NULL,
  `groupFilmId` int(11) NOT NULL COMMENT '投诉团购id',
  `userId` int(11) default NULL COMMENT '会员id',
  `reason` varchar(200) default NULL COMMENT '投诉原因'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_film
-- ----------------------------
DROP TABLE IF EXISTS `t_film`;
CREATE TABLE `t_film` (
  `id` int(11) NOT NULL auto_increment,
  `filmName` varchar(30) default NULL,
  `releaseDate` date default NULL COMMENT '映放日期',
  `version` varchar(10) default NULL COMMENT '版本',
  `country` varchar(20) default NULL COMMENT '地区，美国，中国，香港等等',
  `period` int(11) default NULL COMMENT '时长，分钟',
  `description` varchar(500) default NULL COMMENT '剧情介绍',
  `director` varchar(30) default NULL COMMENT '导演',
  `actors` varchar(100) default NULL COMMENT '演员',
  `star` int(11) default NULL COMMENT '星评，0,1,2,3,4,5',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_group_film
-- ----------------------------
DROP TABLE IF EXISTS `t_group_film`;
CREATE TABLE `t_group_film` (
  `id` int(11) NOT NULL default '0',
  `filmId` int(11) NOT NULL COMMENT '电影id',
  `cityId` int(11) NOT NULL COMMENT '城市id',
  `areaId` int(11) NOT NULL COMMENT '区域id',
  `cinemaId` int(11) NOT NULL COMMENT '电影院id',
  `currentPrice` float NOT NULL COMMENT '折后打价格',
  `originalPrice` float NOT NULL COMMENT '始原价格',
  `startDate` datetime default NULL COMMENT '有效期开始时间',
  `endDate` datetime default NULL COMMENT '有效期结束时间',
  `status` int(11) NOT NULL COMMENT '0:申请中，1：已上架，2：已下架',
  `comment` varchar(300) default NULL COMMENT '备注',
  `type` int(11) NOT NULL COMMENT '电影类型，0：已经上映，1：未上映',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_heart
-- ----------------------------
DROP TABLE IF EXISTS `t_heart`;
CREATE TABLE `t_heart` (
  `id` int(11) NOT NULL auto_increment,
  `filmId` int(11) default NULL COMMENT '电影id',
  `userId` int(11) default NULL COMMENT '会员id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `cinemaId` int(11) default NULL COMMENT '电影院id',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `type` int(11) default NULL COMMENT '0:代表管理员信息  1:代表会员信息，',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL auto_increment,
  `filmId` int(11) default NULL,
  `userId` int(11) default NULL,
  `createTime` datetime default NULL COMMENT '订单日期',
  `expiredTime` datetime default NULL COMMENT '效时间失，超过40分为付款即为失效',
  `status` int(11) default NULL COMMENT '订单状态,0：失效，1：未支付，2：已经支付',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL auto_increment COMMENT '员会id',
  `acountId` int(11) default NULL COMMENT '户账id',
  `username` char(30) NOT NULL COMMENT '用户名',
  `password` char(20) NOT NULL COMMENT '密码',
  `email` char(80) default NULL COMMENT '邮箱',
  `cityId` int(11) default NULL,
  `description` varchar(500) default NULL COMMENT '简介',
  `photoUrl` varchar(300) default NULL COMMENT '头像图片路径',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', null, 'kdf', '123456', null, null, null, null);
INSERT INTO `t_user` VALUES ('2', null, 'kdf', '123456', null, null, null, null);
INSERT INTO `t_user` VALUES ('3', null, 'kdf', '123456', null, null, null, null);
INSERT INTO `t_user` VALUES ('4', null, 'kdf', '123456', null, null, null, null);
INSERT INTO `t_user` VALUES ('5', null, 'kdfd', '123456', null, null, null, null);
INSERT INTO `t_user` VALUES ('6', null, 'kdf', '123456', null, null, null, null);
INSERT INTO `t_user` VALUES ('7', null, 'kongdefei', '123456', null, null, null, null);
