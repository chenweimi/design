DROP TABLE IF EXISTS `product`;
create table `product`
(
    `p_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT 
    COMMENT `表的ID`,
    `p_name` VARCHAR(15) NOT NULL 
    COMMENT `产品的名字`,
    `p_count` INT UNSIGNED NOT NULL 
    COMMENT `产品的数量`,
    PRIMARY KEY (`p_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

drop table if exists `car`;
create table `car`
(
    `c_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT
    COMMENT `表的ID`,
    `c_name` VARCHAR(15) NOT NULL
    COMMENT `车的名字`,
    `c_number` VARCHAR(10) NOT NULL
    COMMENT `车的车牌`,
    `c_status` TINYINT UNSIGNED NOT NULL DEFAULT '0'
    COMMENT `车的状态 默认 0 为可使用 1 为配送中`,
    PRIMARY KEY(`c_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


drop table if exists `employee`;
create table `employee`
(
    `e_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `e_name` VARCHAR(15) NOT NULL,
    `e_sex`  CHAR(2) NOT NULL,
    `e_position` CHAR(5)  NOT NULL,
    `e_comment` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY(`e_id`)
)  
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

  ## 客户表 client

- id
- name

drop table if exists `client`;
create table `client`
(
    `c_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `c_name` VARCHAR(15) NOT NULL,
    PRIMARY KEY(`c_id`)
)  
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


drop table if exists `delivery`;
create table `delivery`
(
    `d_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `client_id` VARCHAR(15) NOT NULL,
    `d_thing`  CHAR(2) NOT NULL,
    `d_start` CHAR(5)  NOT NULL,
    `d_end` VARCHAR(255) DEFAULT NULL,
    `d_status` VARCHAR(255) DEFAULT NULL,
    `car_id` VARCHAR(255) DEFAULT NULL,
    `e_id` VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY(`d_id`)
)  
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


drop table if exists `finance`;
create table `finance`
(
    `f_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `f_total`  CHAR(2) NOT NULL,
    `f_current` CHAR(5)  NOT NULL,
    PRIMARY KEY(`f_id`)
)  
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

