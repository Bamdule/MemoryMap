-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.3.12-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- memory_map 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `memory_map` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `memory_map`;

-- 테이블 memory_map.file_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `file_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `org_file_name` varchar(300) NOT NULL,
  `update_dt` datetime NOT NULL,
  `path` varchar(300) NOT NULL,
  `type` char(2) NOT NULL,
  `create_dt` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 memory_map.memory 구조 내보내기
CREATE TABLE IF NOT EXISTS `memory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `address` varchar(300) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_memory_user_idx` (`user_id`),
  CONSTRAINT `fk_memory_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 memory_map.place 구조 내보내기
CREATE TABLE IF NOT EXISTS `place` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `x` double NOT NULL,
  `y` double NOT NULL,
  `order` int(11) NOT NULL,
  `memory_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Place_memory1_idx` (`memory_id`),
  CONSTRAINT `fk_Place_memory1` FOREIGN KEY (`memory_id`) REFERENCES `memory` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 memory_map.place_file 구조 내보내기
CREATE TABLE IF NOT EXISTS `place_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_info_id` int(11) NOT NULL,
  `place_id` int(11) NOT NULL,
  `order` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_place_file_file1_idx` (`file_info_id`),
  KEY `fk_place_file_place1_idx` (`place_id`),
  CONSTRAINT `fk_place_file_file1` FOREIGN KEY (`file_info_id`) REFERENCES `file_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_place_file_place1` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 memory_map.place_like 구조 내보내기
CREATE TABLE IF NOT EXISTS `place_like` (
  `place_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`place_id`,`user_id`),
  KEY `fk_place_like_place1_idx` (`place_id`),
  KEY `fk_place_like_user1_idx` (`user_id`),
  CONSTRAINT `fk_place_like_place1` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_place_like_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 memory_map.place_reply 구조 내보내기
CREATE TABLE IF NOT EXISTS `place_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(300) NOT NULL,
  `deleted` tinyint(4) NOT NULL DEFAULT 0,
  `reply_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `place_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_place_reply_place_reply_idx` (`reply_id`),
  KEY `fk_place_reply_user1_idx` (`user_id`),
  KEY `fk_place_reply_place1_idx` (`place_id`),
  CONSTRAINT `fk_place_reply_place1` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_place_reply_place_reply` FOREIGN KEY (`reply_id`) REFERENCES `place_reply` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_place_reply_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 memory_map.place_tag 구조 내보내기
CREATE TABLE IF NOT EXISTS `place_tag` (
  `tag_id` int(11) NOT NULL,
  `place_id` int(11) NOT NULL,
  PRIMARY KEY (`tag_id`,`place_id`),
  KEY `fk_place_tag_tag1_idx` (`tag_id`),
  KEY `fk_place_tag_place1_idx` (`place_id`),
  CONSTRAINT `fk_place_tag_place1` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_place_tag_tag1` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 memory_map.place_view 구조 내보내기
CREATE TABLE IF NOT EXISTS `place_view` (
  `place_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`place_id`,`user_id`),
  KEY `fk_place_view_place1_idx` (`place_id`),
  KEY `fk_place_view_user1_idx` (`user_id`),
  CONSTRAINT `fk_place_view_place1` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_place_view_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 memory_map.property 구조 내보내기
CREATE TABLE IF NOT EXISTS `property` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `value` varchar(300) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 memory_map.seq_file 구조 내보내기
CREATE TABLE IF NOT EXISTS `seq_file` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 memory_map.tag 구조 내보내기
CREATE TABLE IF NOT EXISTS `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 memory_map.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `account` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `profile_img_id` int(11) DEFAULT NULL,
  `create_dt` datetime DEFAULT NULL,
  `update_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_file1_idx` (`profile_img_id`),
  CONSTRAINT `fk_user_file1` FOREIGN KEY (`profile_img_id`) REFERENCES `file_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 memory_map.user_follower 구조 내보내기
CREATE TABLE IF NOT EXISTS `user_follower` (
  `user_id` int(11) NOT NULL,
  `follower_user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`follower_user_id`),
  KEY `fk_user_follower_user1_idx` (`user_id`),
  KEY `fk_user_follower_user2_idx` (`follower_user_id`),
  CONSTRAINT `fk_user_follower_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_follower_user2` FOREIGN KEY (`follower_user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 memory_map.user_following 구조 내보내기
CREATE TABLE IF NOT EXISTS `user_following` (
  `user_id` int(11) NOT NULL,
  `following_user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`following_user_id`),
  KEY `fk_user_following_user1_idx` (`user_id`),
  KEY `fk_user_following_user2_idx` (`following_user_id`),
  CONSTRAINT `fk_user_following_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_following_user2` FOREIGN KEY (`following_user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
