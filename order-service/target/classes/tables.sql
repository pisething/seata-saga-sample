USE seata_saga_demo;

CREATE TABLE `seata_state_machine_def` (
  `id` VARCHAR(128) NOT NULL,
  `name` VARCHAR(128) NOT NULL,
  `tenant_id` VARCHAR(32) DEFAULT '',
  `app_name` VARCHAR(64) DEFAULT '',
  `type` VARCHAR(20) DEFAULT '',
  `comment_` VARCHAR(255),
  `ver` VARCHAR(16) NOT NULL,
  `content` LONGTEXT NOT NULL,
  `status` VARCHAR(2) NOT NULL DEFAULT '1',
  `recover_strategy` VARCHAR(16),
  `gmt_create` DATETIME,
  `gmt_modified` DATETIME,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name_ver` (`name`, `ver`)
);

CREATE TABLE IF NOT EXISTS `seata_state_machine_inst` (
  `id` VARCHAR(128) PRIMARY KEY,
  `machine_id` VARCHAR(128),
  `tenant_id` VARCHAR(32),
  `parent_id` VARCHAR(128),
  `gmt_started` DATETIME,
  `gmt_end` DATETIME,
  `business_key` VARCHAR(128),
  `start_params` LONGTEXT,
  `end_params` LONGTEXT,
  `excep` BLOB, 
  `status` VARCHAR(2),
  `compensation_status` VARCHAR(2),
  `is_running` TINYINT(1),
  `gmt_updated` DATETIME
);

CREATE TABLE IF NOT EXISTS `seata_state_inst` (
  `id` VARCHAR(128) PRIMARY KEY,
  `machine_inst_id` VARCHAR(128),
  `name` VARCHAR(128),
  `type` VARCHAR(128),
  `service_name` VARCHAR(128),
  `service_method` VARCHAR(128),
  `service_type` VARCHAR(20),
  `gmt_started` DATETIME,
  `gmt_end` DATETIME,
  `status` VARCHAR(2),
  `input_params` LONGTEXT,
  `output_params` LONGTEXT,
  `excep` BLOB, 
  `state_id_compensated_for` VARCHAR(128),
  `state_id_retried_for` VARCHAR(128),
  `is_for_update` TINYINT(1),
  `business_key` VARCHAR(128),
  `gmt_updated` DATETIME
);
