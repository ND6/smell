# Dump of table LoggerConfiguration
# ------------------------------------------------------------

DROP TABLE IF EXISTS `LoggerConfiguration`;

CREATE TABLE `LoggerConfiguration`
(
    `Id`              int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `Name`            varchar(500) NOT NULL DEFAULT 'default' COMMENT 'AppID',
    `ConfiguredLevel` varchar(500) NOT NULL DEFAULT 'default' COMMENT '配置级别',
    `EffectiveLevel`  varchar(500) NOT NULL DEFAULT 'default' COMMENT '有效级别',
    `IsDeleted`       bit(1)       NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
    `DeletedAt`       BIGINT(20) NOT NULL DEFAULT '0' COMMENT 'Delete timestamp based on milliseconds',
    PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='日志配置表';