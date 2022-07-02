CREATE TABLE `work_space` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `work_space_name` varchar(128) DEFAULT NULL COMMENT '工作区名称',
  `work_space_description` varchar(128) DEFAULT NULL COMMENT '工作区描述',
  `work_space_type` varchar(128) DEFAULT NULL COMMENT '工作区类型',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COMMENT='工作区';


CREATE TABLE `board` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `work_space_id` bigint(20) DEFAULT NULL COMMENT '系统Id',
  `board_name` varchar(128) DEFAULT NULL COMMENT '看板名称',
  `board_description` varchar(128) DEFAULT NULL COMMENT '看板描述',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COMMENT='看板';
