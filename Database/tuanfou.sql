/*
MySQL Data Transfer
Source Host: localhost
Source Database: tuanfou
Target Host: localhost
Target Database: tuanfou
Date: 2014-7-9 9:24:33
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
  `auditResult` int(1) default NULL COMMENT '状态 0：审核中 1：审核通过 2：审核未通过',
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
  `status` int(11) NOT NULL COMMENT '1：已上架，2：已下架',
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
  `expiredTime` datetime default NULL COMMENT 's失效时间，与groupfilm的下架时间对应',
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
  `sex` int(10) default NULL COMMENT '1男        2女',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `t_account` VALUES ('1', '1065');
INSERT INTO `t_account` VALUES ('2', '12220');
INSERT INTO `t_account` VALUES ('3', '1055555');
INSERT INTO `t_account` VALUES ('4', '5');
INSERT INTO `t_account` VALUES ('5', '1089');
INSERT INTO `t_account` VALUES ('6', '6666');
INSERT INTO `t_account` VALUES ('7', '2356');
INSERT INTO `t_account` VALUES ('8', '9462');
INSERT INTO `t_account` VALUES ('9', '57621');
INSERT INTO `t_account` VALUES ('10', '32');
INSERT INTO `t_account` VALUES ('14', '0');
INSERT INTO `t_account` VALUES ('15', '0');
INSERT INTO `t_account` VALUES ('16', '0');
INSERT INTO `t_account` VALUES ('17', '0');
INSERT INTO `t_account` VALUES ('18', '0');
INSERT INTO `t_account` VALUES ('19', '0');
INSERT INTO `t_account` VALUES ('20', '0');
INSERT INTO `t_account` VALUES ('21', '0');
INSERT INTO `t_account` VALUES ('22', '0');
INSERT INTO `t_account` VALUES ('23', '0');
INSERT INTO `t_account` VALUES ('24', '0');
INSERT INTO `t_account` VALUES ('25', '0');
INSERT INTO `t_account` VALUES ('26', '0');
INSERT INTO `t_account` VALUES ('27', '0');
INSERT INTO `t_account` VALUES ('28', '0');
INSERT INTO `t_account` VALUES ('29', '0');
INSERT INTO `t_account` VALUES ('30', '0');
INSERT INTO `t_account` VALUES ('31', '0');
INSERT INTO `t_account` VALUES ('32', '0');
INSERT INTO `t_account` VALUES ('33', '100');
INSERT INTO `t_account` VALUES ('34', '100');
INSERT INTO `t_account` VALUES ('35', '100');
INSERT INTO `t_admin` VALUES ('30601001', '001', '123001');
INSERT INTO `t_admin` VALUES ('31201002', '007', '123007');
INSERT INTO `t_area` VALUES ('3010101', '海淀区', '30101');
INSERT INTO `t_area` VALUES ('3010102', '东城区', '30101');
INSERT INTO `t_area` VALUES ('3160101', '双城区', '31601');
INSERT INTO `t_area` VALUES ('3190101', '洪山区', '31901');
INSERT INTO `t_area` VALUES ('3190102', '武昌区', '31901');
INSERT INTO `t_area` VALUES ('3190103', '青山区', '31901');
INSERT INTO `t_area` VALUES ('3190104', '汉阳区', '31901');
INSERT INTO `t_area` VALUES ('3210101', '盘龙区', '32101');
INSERT INTO `t_area` VALUES ('3220101', '城北区', '32201');
INSERT INTO `t_area` VALUES ('3300101', '青秀区', '33001');
INSERT INTO `t_cinema` VALUES ('301010101', '6', '美嘉欢乐影城MEGABOX', '13546876432', '环境优美，免费wifi', '3010101', '中关村广场');
INSERT INTO `t_cinema` VALUES ('301010201', '7', ' 百老汇电影院', '13569872465', '环境优美，免费wifi', '3010102', '崇文门外大街18号');
INSERT INTO `t_cinema` VALUES ('301010202', '8', '新世纪影院', '13845121354', '环境优美，免费wifi', '3010102', '王府井大街218号');
INSERT INTO `t_cinema` VALUES ('301010203', '9', ' 北京搜秀电影城', '13546245876', '环境优美，免费wifi', '3010102', '崇文门外大街40号');
INSERT INTO `t_cinema` VALUES ('301010204', '10', '蟾宫电影院', '13546245875', '环境优美，免费wifi', '3010102', '东四隆福寺街75号');
INSERT INTO `t_cinema` VALUES ('319010101', '1', '洪山天河国际影城', '13517232264', '环境优美，免费wifi', '3190101', '珞瑜路6号');
INSERT INTO `t_cinema` VALUES ('319010102', '2', '金逸国际电影城', '13856478952', '环境优美，免费wifi', '3190101', '丁字桥南路');
INSERT INTO `t_cinema` VALUES ('319010103', '3', '武汉中影天河影院', '13571333267', '环境优美，免费wifi', '3190101', '光谷步行街');
INSERT INTO `t_cinema` VALUES ('319010201', '5', '武商摩尔国际电影城', '13546216574', '环境优美，免费wifi', '3190102', '解放大道690号');
INSERT INTO `t_cinema` VALUES ('319010301', '4', '青山天河国际电影城', '13579542325', '环境优美，免费wifi', '3190103', '建设七路52号');
INSERT INTO `t_city` VALUES ('30101', '北京');
INSERT INTO `t_city` VALUES ('30201', '上海');
INSERT INTO `t_city` VALUES ('30301', '天津');
INSERT INTO `t_city` VALUES ('30401', '重庆');
INSERT INTO `t_city` VALUES ('30501', '澳门');
INSERT INTO `t_city` VALUES ('30601', '香港');
INSERT INTO `t_city` VALUES ('30701', '石家庄');
INSERT INTO `t_city` VALUES ('30801', '长春');
INSERT INTO `t_city` VALUES ('30901', '南京');
INSERT INTO `t_city` VALUES ('31001', '福州');
INSERT INTO `t_city` VALUES ('31101', '郑州');
INSERT INTO `t_city` VALUES ('31201', '广州');
INSERT INTO `t_city` VALUES ('31301', '贵阳');
INSERT INTO `t_city` VALUES ('31401', '兰州');
INSERT INTO `t_city` VALUES ('31501', '太原');
INSERT INTO `t_city` VALUES ('31601', '哈尔滨');
INSERT INTO `t_city` VALUES ('31701', '杭州');
INSERT INTO `t_city` VALUES ('31801', '台北');
INSERT INTO `t_city` VALUES ('31901', '武汉');
INSERT INTO `t_city` VALUES ('32001', '海口');
INSERT INTO `t_city` VALUES ('32101', '昆明');
INSERT INTO `t_city` VALUES ('32201', '西宁');
INSERT INTO `t_city` VALUES ('32301', '沈阳');
INSERT INTO `t_city` VALUES ('32401', '济南');
INSERT INTO `t_city` VALUES ('32501', '合肥');
INSERT INTO `t_city` VALUES ('32601', '南昌');
INSERT INTO `t_city` VALUES ('32701', '长沙');
INSERT INTO `t_city` VALUES ('32801', '城都');
INSERT INTO `t_city` VALUES ('32901', '西安');
INSERT INTO `t_city` VALUES ('33001', '南宁');
INSERT INTO `t_city` VALUES ('33101', '呼和浩特');
INSERT INTO `t_city` VALUES ('33201', '拉萨');
INSERT INTO `t_city` VALUES ('33301', '银川');
INSERT INTO `t_city` VALUES ('33401', '乌鲁木齐');
INSERT INTO `t_comment` VALUES ('1', '1', '302010010', '2014-07-02 15:02:15', '不错额1', '4');
INSERT INTO `t_comment` VALUES ('2', '1', '319010001', '2014-06-28 00:00:00', '不错额2', '5');
INSERT INTO `t_comment` VALUES ('3', '1', '319010023', '2014-06-28 00:00:00', '不错额3', '4');
INSERT INTO `t_comment` VALUES ('4', '2', '302010010', '2014-07-02 08:54:30', '不错额4', '3');
INSERT INTO `t_comment` VALUES ('5', '2', '309010006', '2014-07-02 08:54:39', '不错额5', '3');
INSERT INTO `t_comment` VALUES ('6', '5', '319010001', '2014-07-02 08:54:46', '不错额6', '5');
INSERT INTO `t_comment` VALUES ('7', '7', '309010006', '2014-07-02 08:54:51', '不错额7', '5');
INSERT INTO `t_comment` VALUES ('8', '10', '304010333', '2014-07-02 08:55:00', '不错额8', '4');
INSERT INTO `t_comment` VALUES ('9', '7', '307016211', '2014-07-02 08:55:10', '不错额9', '4');
INSERT INTO `t_comment` VALUES ('10', '9', '304010321', '2014-07-02 08:55:18', '不错额10', '5');
INSERT INTO `t_complaint` VALUES ('1', '1', '304010333', '不好看');
INSERT INTO `t_complaint` VALUES ('2', '1', '307016211', '环境不好');
INSERT INTO `t_complaint` VALUES ('3', '1', '307016211', '态度不好');
INSERT INTO `t_complaint` VALUES ('4', '4', '307016213', '态度不好');
INSERT INTO `t_complaint` VALUES ('5', '4', '307016213', '态度不好');
INSERT INTO `t_complaint` VALUES ('6', '6', '319010023', '环境不好');
INSERT INTO `t_complaint` VALUES ('7', '9', '319010023', '环境不好');
INSERT INTO `t_complaint` VALUES ('8', '10', '326011111', '不好看');
INSERT INTO `t_complaint` VALUES ('9', '8', '304010333', '不好看');
INSERT INTO `t_complaint` VALUES ('10', '7', '326011111', '态度不好');
INSERT INTO `t_film` VALUES ('1', '4', '变形金刚', '2014-07-23', '4', '美国', '150', '芝加哥一战后,汽车人、霸天虎销声匿迹。一群天才科学家欲研发难以驾驭的新技术。而一个古老强大的变形金刚出现并威胁着人类，决战一触即发', '马克·沃尔伯格', '斯坦利突起', '4', '1', '2014-06-28 23:44:26', '1');
INSERT INTO `t_film` VALUES ('2', '4', '超凡蜘蛛侠', '2014-07-31', '1', '美国', '120', '童年的一起突发事件，令彼得·帕克（安德鲁·加菲尔德 Andrew Garfield 饰）和父母生离死别。转眼彼得成为一名高中生，他偶然发现父亲的公文包，并从叔父本（马丁·辛 Martin Sheen 饰）处得到线索，于是启程前往奥斯库公司拜访父亲当年的合作伙伴——科特·康纳斯博士（瑞斯·伊凡斯 Rhys Ifans 饰）。在公司内四处寻找线索的彼得意外被蜘蛛咬了一口，回程途中他的身体发生奇异的变化。在康纳斯博士德引导下，彼得不断了解并发掘体内着超乎寻常的能力，喜怒哀乐，各种意想不到的事情迅速向他袭来。直到某日，他便成了影响深远的超级战士蜘蛛侠。而城市内也出现了凶恶的蜥蜴人，彼得不平凡的人生就此展开', '马克·韦布', '马丁·辛', '5', '2', '2014-06-29 00:00:56', '2');
INSERT INTO `t_film` VALUES ('3', '4', '美国队长2', '2014-07-23', '2', '美国', '120', '在经历了纽约大战后，美国队长史蒂夫·罗杰斯（克里斯·埃文斯 Chris Evans 饰）在华盛顿过着恬淡的生活', '安东尼·罗素', '克里斯·埃文斯', '5', '2', '2014-07-01 16:52:47', '2');
INSERT INTO `t_film` VALUES ('4', '4', '白日火焰', '2014-07-29', '1', '中国 ', '100', '外表冷艳的吴志贞（桂纶镁 饰）身上散发着熟女的魅力，这对于男人来说是一种致命的诱惑，对于与她曾有过一面之缘的警察张自力（廖凡 饰）来说更是如此五年前，吴志贞的丈夫梁志军（王学兵 饰）被警方认定死于一桩离奇碎尸案，当时张自力破案后击毙了持枪拒捕的凶手。五年后，又发生了类似的连环案件，并且这些死者都曾与吴志贞相恋，心结未了的张自力主动接近吴志贞，却飞蛾扑火般的爱上了这个女人，两人遭遇重大生活挫折的人逐渐从惺惺相惜到相爱，随着更加亲密的接触，张自力发现了五年前的真相', '刁亦男', '桂纶镁', '4', '1', '2014-06-30 16:58:00', '1');
INSERT INTO `t_film` VALUES ('5', '4', '十二生肖', '2014-07-28', '1', '中国 ', '99', '杰克为领取国际文物贩子劳伦斯开出的巨额奖金，四处寻找“圆明园”十二生肖中失散的最后四个兽首。在寻宝过程中，他爱上了中国文物专家关教授的女儿Coco。被关教授父女的爱国情怀所感动，一向惜金如命的杰克在最后关头放弃了金钱，转而帮助Coco全力挽救国宝，最终将寻回的兽首归还中国。十二生肖是成龙出演的第100部电影，这也可能是成龙的最后一部动作片。', '成龙 ', '成龙 ', '5', '0', '2014-07-01 17:01:29', '0');
INSERT INTO `t_film` VALUES ('6', '1', '无人区', '2014-07-28', '1', '中国', '103', '小有名气但利欲熏心的律师潘肖（徐峥饰），凭借扎实的法律知识和巧舌如簧的庭辩技巧，成功帮盗捕国家珍禽阿拉泰隼并残忍杀害一名警察的西北盗猎团伙老大（多布杰 饰）洗脱罪名。老大承诺十天后付清余款，潘肖则要求对方用一辆红色轿车抵押。在此之后，他驾驶着新车踏上从西北荒漠返回大都会的路程。谁知路上险情不断，先是和一对开卡车拉茅草的哥俩（王双宝 & 巴多 饰）发生摩擦，导致人伤车损，接着又不慎撞飞一个似乎拦车求助的男子（黄渤 饰）。自知摊上人命的潘肖辗转来到一家专事不法勾当的黑店，并在此结识了受困于此的妓女（余男 饰）。与此同时，盗猎老大尾随其后，似乎另有凶险计划。 　　此时潘肖还没真正意识到，他前方是怎样一条充满凶险的旅途', '宁浩', '黄渤', '4', '1', '2014-07-02 17:02:58', '1');
INSERT INTO `t_film` VALUES ('7', '1', '冰雪奇缘', '2014-07-28', '1', '美国', '108', '《Frozen》讲述一个诅咒令王国被冰天雪地永久覆盖，乐观无畏的安娜（由克里斯汀·贝尔配音）和一个大胆的山民克里斯托弗以及陪伴他左右的驯鹿斯文组队出发，遭遇了喜马拉雅山般的极端气候、神秘的生物与无处不在的魔法，不但为了寻到安娜的姐姐——冰雪皇后埃尔莎（由埃蒂纳·曼泽尔配音），更希望能破除冰封魔咒，拯救王国免遭灭顶之灾。', '克里斯·巴克', '易迪娜·门泽尔', '5', '1', '2014-07-01 17:06:15', '1');
INSERT INTO `t_film` VALUES ('8', '1', '窃听风云2', '2014-07-28', '2', '香港', '114', '香港证券商人罗敏生驱车上班途中遭遇车祸。警方在罗的车内发现军用窃听器，反恐队长何智强怀疑有人正在策划恐怖袭击。随着何的调查，始终藏在暗处监视窃听的退伍军人司马念祖也渐渐浮出水面。与此同时，罗将被窃听的消息告诉了“地主会”的元老们，这是一群自70年代起便操纵香港金融的业界精英，如今更成为只手遮天的抢钱大亨。原以为只会是普通的勒索案，却将罗、何、司马等人卷入了万劫不复的漩涡之中。', '麦兆辉', '古天乐', '5', '0', '2014-07-01 17:08:38', '0');
INSERT INTO `t_film` VALUES ('9', '2', '驯龙高手2', '2014-07-28', '2', '美国', '120', '《驯龙高手》第一部的两位导演克里斯·桑德斯和迪恩·德布洛斯，在续集中将以另外一种形式合作：迪恩·德布洛斯“单飞”挑起导演大梁，独自执导《驯龙高手2》，克里斯·桑德斯则将出任执行制片人。所有台前配音以及幕后主创原班人马将悉数回归这部续集。杰伊·巴鲁切尔，克雷格·费格森，亚美莉卡·费雷拉，乔纳·希尔，克里斯托夫·梅兹-普莱瑟和克里斯汀·韦格等演员都将继续为影片里的角色担任配音。当然，大家最爱的没牙仔和其他可爱的小龙也都会继续出现在《驯龙高手2》中。', '迪恩·德布洛斯', '杰伊·巴鲁切尔', '5', '0', '2014-07-02 17:11:06', '0');
INSERT INTO `t_film` VALUES ('10', '2', '霍比特人3', '2014-07-28', '3', '美国', '124', '根据英国作家J.R.R·托尔金1937年出版的同名长篇小说改编。又名《哈比特人历险记》或《去而复返-一个霍比特人的故事》。（原著中由比尔博本人亲自撰写。） 　　因此书而延伸出的《 魔戒 》和其后的故事，托尔金因此一举成名。 　　故事讲述记述霍比特人比尔博.巴金斯与巫师甘道夫和十三名矮人向东旅行横越中土大陆，寻找被恶龙抢占的属于矮人珍贵宝物的探险故事。 　　据目前证实，本片的第二部剧情将依据原著相关资料对小说故事进行延伸，讲述比尔博返乡乃至《魔戒》剧情开始之间六十年的故事。', '彼得·杰克逊', '马丁·弗瑞曼', '5', '1', '2014-07-03 17:14:22', '1');
INSERT INTO `t_film_tag` VALUES ('1', '1', '2');
INSERT INTO `t_film_tag` VALUES ('2', '1', '3');
INSERT INTO `t_film_tag` VALUES ('3', '1', '4');
INSERT INTO `t_film_tag` VALUES ('4', '2', '2');
INSERT INTO `t_film_tag` VALUES ('5', '3', '2');
INSERT INTO `t_film_tag` VALUES ('6', '3', '3');
INSERT INTO `t_film_tag` VALUES ('7', '3', '11');
INSERT INTO `t_film_tag` VALUES ('8', '4', '12');
INSERT INTO `t_film_tag` VALUES ('9', '5', '2');
INSERT INTO `t_film_tag` VALUES ('10', '5', '9');
INSERT INTO `t_film_tag` VALUES ('11', '5', '11');
INSERT INTO `t_film_tag` VALUES ('12', '5', '5');
INSERT INTO `t_film_tag` VALUES ('13', '5', '13');
INSERT INTO `t_film_tag` VALUES ('14', '6', '13');
INSERT INTO `t_film_tag` VALUES ('15', '6', '4');
INSERT INTO `t_film_tag` VALUES ('16', '7', '7');
INSERT INTO `t_film_tag` VALUES ('17', '8', '5');
INSERT INTO `t_film_tag` VALUES ('18', '9', '7');
INSERT INTO `t_film_tag` VALUES ('19', '10', '8');
INSERT INTO `t_film_tag` VALUES ('20', '10', '13');
INSERT INTO `t_group_film` VALUES ('1', '1', '3190101', '319010103', '19.99', '80', '2014-07-06 12:59:52', '2014-08-03 13:00:11', '1', '不错的电影1', '0', './imgs/变形金刚4.jpg');
INSERT INTO `t_group_film` VALUES ('2', '1', '3190101', '319010101', '29.8', '90', '2014-07-06 12:59:52', '2014-08-03 00:00:00', '1', '不错的电影2', '0', './imgs/变形金刚4.jpg');
INSERT INTO `t_group_film` VALUES ('3', '1', '3190101', '319010102', '39', '100', '2014-07-06 12:59:52', '2014-08-03 00:00:00', '1', '不错的电影3', '1', './imgs/变形金刚4.jpg');
INSERT INTO `t_group_film` VALUES ('4', '4', '3190101', '319010102', '20', '80', '2014-07-06 12:59:52', '2014-08-03 00:00:00', '1', '不错的电影4', '1', './imgs/白日火焰.jpg');
INSERT INTO `t_group_film` VALUES ('5', '4', '3190102', '319010201', '30', '100', '2014-07-06 12:59:52', '2014-08-03 00:00:00', '1', '不错的电影5', '1', './imgs/白日火焰.jpg');
INSERT INTO `t_group_film` VALUES ('6', '6', '3190102', '301010201', '30', '100', '2014-07-06 12:59:52', '2014-08-03 00:00:00', '1', '不错的电影6', '0', './imgs/无人区.jpg');
INSERT INTO `t_group_film` VALUES ('7', '6', '3190102', '319010201', '35', '100', '2014-07-06 12:59:52', '2014-08-03 00:00:00', '1', '不错的电影7', '0', './imgs/无人区.jpg');
INSERT INTO `t_group_film` VALUES ('8', '7', '3190103', '319010301', '33', '100', '2014-07-06 12:59:52', '2014-08-03 00:00:00', '1', '不错的电影8', '1', './imgs/冰雪奇缘.jpg');
INSERT INTO `t_group_film` VALUES ('9', '7', '3190103', '319010301', '32', '100', '2014-07-06 12:59:52', '2014-08-03 00:00:00', '1', '不错的电影9', '1', './imgs/冰雪奇缘.jpg');
INSERT INTO `t_group_film` VALUES ('10', '10', '3190103', '319010301', '31', '100', '2014-07-06 12:59:52', '2014-08-03 00:00:00', '1', '不错的电影10', '0', './imgs/霍比特人3.jpg');
INSERT INTO `t_heart` VALUES ('1', '1', '307016211');
INSERT INTO `t_heart` VALUES ('2', '1', '309010006');
INSERT INTO `t_heart` VALUES ('3', '1', '309010056');
INSERT INTO `t_heart` VALUES ('4', '5', '307016211');
INSERT INTO `t_heart` VALUES ('5', '5', '322011654');
INSERT INTO `t_heart` VALUES ('6', '9', '307016211');
INSERT INTO `t_heart` VALUES ('7', '8', '322011654');
INSERT INTO `t_heart` VALUES ('8', '8', '326011111');
INSERT INTO `t_heart` VALUES ('9', '10', '302010010');
INSERT INTO `t_heart` VALUES ('10', '2', '326011111');
INSERT INTO `t_merchant` VALUES ('1', '孔德飞', '123456', '41048219920213671X', 'default.jpg');
INSERT INTO `t_merchant` VALUES ('2', '赖楠', '123456', '410488199408261111', 'default.jpg');
INSERT INTO `t_merchant` VALUES ('3', '黄灿圳', '123456', '123456789012342222', 'default.jpg');
INSERT INTO `t_merchant` VALUES ('4', '徐玉吉大老板', '123456', '222222222222222222', 'default.jpg');
INSERT INTO `t_merchant` VALUES ('5', '柴炳蔚', '123456', '467623435443434465', 'default.jpg');
INSERT INTO `t_merchant` VALUES ('6', '王毅', '132465', '465434134354354344', 'default.jpg');
INSERT INTO `t_merchant` VALUES ('7', '李二', '123465', '123546546464646464', 'default.jpg');
INSERT INTO `t_merchant` VALUES ('8', 'l刘三', '123456', '354647446546467487', 'default.jpg');
INSERT INTO `t_merchant` VALUES ('9', '章四', '123465', '635487879869543213', 'default.jpg');
INSERT INTO `t_merchant` VALUES ('10', '徐五', '132465', '135464213246453112', 'default.jpg');
INSERT INTO `t_merchant` VALUES ('13', '测试商家', '777777888', '465aaaxaax', 'default.jpg');
INSERT INTO `t_merchant` VALUES ('14', '测试商家', '777777888', '465aaaxaax', 'default.jpg');
INSERT INTO `t_merchant` VALUES ('15', '测试商家', '777777888', '465aaaxaax1', 'default.jpg');
INSERT INTO `t_message` VALUES ('1', '30601001', '5', 'hello,i am kdf', '2014-06-28 13:01:18', '0');
INSERT INTO `t_message` VALUES ('2', '31201002', '2', 'hello2', '2014-07-02 09:24:16', '0');
INSERT INTO `t_message` VALUES ('3', '10', '31201002', 'hello3', '2014-07-02 09:24:23', '0');
INSERT INTO `t_message` VALUES ('4', '30601001', '307016211', 'hello4', '2014-07-02 09:24:31', '1');
INSERT INTO `t_message` VALUES ('5', '31201002', '304010333', 'hello5', '2014-07-02 09:24:37', '1');
INSERT INTO `t_message` VALUES ('6', '304010321', '31201002', 'hello6', '2014-07-02 09:24:42', '1');
INSERT INTO `t_message` VALUES ('7', '319010023', '304010333', 'hello7', '2014-07-02 09:24:47', '2');
INSERT INTO `t_message` VALUES ('8', '322011654', '319010023', 'hello8', '2014-07-02 09:25:00', '2');
INSERT INTO `t_message` VALUES ('9', '326011111', '304010321', 'hello9', '2014-07-02 09:25:06', '2');
INSERT INTO `t_message` VALUES ('10', '322011654', '319010023', 'hello10', '2014-07-02 09:25:13', '2');
INSERT INTO `t_order` VALUES ('1', '1', '302010010', '2014-06-28 13:01:33', '2014-08-03 13:00:11', '1');
INSERT INTO `t_order` VALUES ('2', '1', '304010321', '2014-07-02 09:30:59', '2014-08-03 13:00:11', '1');
INSERT INTO `t_order` VALUES ('3', '1', '304010333', '2014-07-02 09:35:20', '2014-08-03 13:00:11', '1');
INSERT INTO `t_order` VALUES ('4', '2', '302010010', '2014-07-02 09:35:29', '2014-08-03 00:00:00', '1');
INSERT INTO `t_order` VALUES ('5', '2', '304010333', '2014-07-02 09:35:36', '2014-08-03 00:00:00', '1');
INSERT INTO `t_order` VALUES ('6', '9', '319010023', '2014-07-02 09:35:55', '2014-08-03 00:00:00', '2');
INSERT INTO `t_order` VALUES ('7', '3', '304010333', '2014-07-02 09:36:01', '2014-08-03 00:00:00', '2');
INSERT INTO `t_order` VALUES ('8', '4', '309010006', '2014-07-02 09:36:01', '2014-08-03 00:00:00', '2');
INSERT INTO `t_order` VALUES ('9', '10', '309010056', '2014-07-02 09:36:01', '2014-08-03 00:00:00', '2');
INSERT INTO `t_order` VALUES ('10', '8', '319010001', '2014-07-02 09:36:01', '2014-08-03 00:00:00', '2');
INSERT INTO `t_tag` VALUES ('1', '爱情', '0');
INSERT INTO `t_tag` VALUES ('2', '动作', '0');
INSERT INTO `t_tag` VALUES ('3', '科幻', '1');
INSERT INTO `t_tag` VALUES ('4', '惊悚', '0');
INSERT INTO `t_tag` VALUES ('5', '悬疑', '0');
INSERT INTO `t_tag` VALUES ('6', '战争', '0');
INSERT INTO `t_tag` VALUES ('7', '动画', '0');
INSERT INTO `t_tag` VALUES ('8', '魔幻', '0');
INSERT INTO `t_tag` VALUES ('9', '喜剧', '0');
INSERT INTO `t_tag` VALUES ('10', '伦理', '0');
INSERT INTO `t_tag` VALUES ('11', '冒险', '0');
INSERT INTO `t_tag` VALUES ('12', '犯罪', '0');
INSERT INTO `t_tag` VALUES ('13', '剧情', '0');
INSERT INTO `t_user` VALUES ('302010010', '2', '李晓峰', '1232', 'kdf5000@163.com', '30201', 'hello2', 'photo.jpg', '1');
INSERT INTO `t_user` VALUES ('304010321', '3', '黄子龙', '1233', 'kdf@163.com', '30401', 'hello3', 'kdf.jpg', '1');
INSERT INTO `t_user` VALUES ('304010333', '8', '高笑笑', '1238', 'kdf@163.com', '30401', 'h8', 'kdf.jpg', '2');
INSERT INTO `t_user` VALUES ('307016211', '4', '王佳佳', '1234', 'kdf@163.com', '30701', 'hello4', 'kdf.jpg', '2');
INSERT INTO `t_user` VALUES ('309010006', '5', '李师师', '1235', 'kdf@163.com', '30901', 'hello5', 'kdf.jpg', '2');
INSERT INTO `t_user` VALUES ('309010056', '9', '郝歌哥', '1239', 'kdf@163.com', '30701', 'h9', 'kdf.jpg', '1');
INSERT INTO `t_user` VALUES ('319010001', '1', '张大伟', '1231', 'kdf@163.com', '31901', 'hello1', 'kdf.jpg', '1');
INSERT INTO `t_user` VALUES ('319010023', '6', '徐霞客', '1236', 'kdf@163.com', '31901', 'h6', 'kdf.jpg', '1');
INSERT INTO `t_user` VALUES ('322011654', '7', '邓紫棋', '1237', 'kdf@163.com', '32201', 'h7', 'kdf.jpg', '2');
INSERT INTO `t_user` VALUES ('326011111', '10', '齐大光', '12310', 'kdf@163.com', '32601', 'h10', 'kdf.jpg', '1');
INSERT INTO `t_user` VALUES ('326011112', '30', 'testAddUser', '5555566666', null, '31901', null, null, null);
INSERT INTO `t_user` VALUES ('326011113', '31', 'testAddUser', '5555566666', null, '31901', null, null, null);
INSERT INTO `t_user` VALUES ('326011114', '32', 'testAddUser1', '5555566666', null, '31901', null, null, null);
INSERT INTO `t_user` VALUES ('326011115', '33', 'woshidoubi', '55555', '1216075682@qq.com', '31901', 'woshidoubi', null, null);
INSERT INTO `t_user` VALUES ('326011116', '34', 'PL', '55555', '1216075681@qq.com', '30201', 'PPLL', null, null);
INSERT INTO `t_user` VALUES ('326011117', '35', 'TuanFou', '88888', '1216075645@qq.com', '30101', 'Hao', null, null);
