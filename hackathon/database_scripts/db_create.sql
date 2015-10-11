use paypalhackathon;

CREATE TABLE `content_settings` (
  `content_settings_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) not null,
  `content_id` varchar(30) not null unique,
  `content_type_name` varchar(20) DEFAULT NULL,
  `field_type` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`content_settings_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

CREATE TABLE `job_settings` (
  `job_settings_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `job_description` varchar(255) not null,
  `job_title` varchar(30) NOT NULL,
  `job_type` varchar(20) NOT NULL,
  PRIMARY KEY (`job_settings_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `gender` varchar(1) DEFAULT NULL,
  `first_name` varchar(50) NOT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) NOT NULL,
  `address1` varchar(100) DEFAULT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state_code` varchar(2) DEFAULT NULL,
  `email` varchar(50) NOT NULL UNIQUE,
  `mobile` varchar(15) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `zipcode` varchar(5) DEFAULT NULL,
  `created_date` datetime NOT NULL,
  `modified_date` datetime NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;


CREATE TABLE `event_settings` (
  `event_settings_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `event_details` varchar(255) not null,
  `event_name` varchar(30) not null,
  `event_creation_date` datetime not null,
  `event_date` datetime not null,
  `user_email` varchar(50) not null,
  PRIMARY KEY (`event_settings_id`),
  CONSTRAINT `user_fk`  FOREIGN KEY (`user_email`) REFERENCES `user`(`email`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

CREATE TABLE `user_roles` (
  `user_role_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) not null,
  `role`  varchar(50) not null,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

CREATE  TABLE users (
  username VARCHAR(50) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));

