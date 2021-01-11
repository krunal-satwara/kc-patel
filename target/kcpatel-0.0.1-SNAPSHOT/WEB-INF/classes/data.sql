DROP TABLE `kcpatel`.`navigation_master`;
CREATE TABLE `kcpatel`.`navigation_master` (`navigation_master_id` bigint NOT NULL,`display_name` varchar(255) DEFAULT NULL,`navigation_url` varchar(255) DEFAULT NULL,PRIMARY KEY (`navigation_master_id`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (1,'/dashboard','DASHBOARD');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (2,'/users','USER MANAGEMENT');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (3,'/customer','CUSTOMER MANAGEMENT');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (4,'/inquiry','INQUIRY');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (5,'/trademark','TRADEMARK');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (6,'/design','DESIGN');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (7,'/patent','PATENT');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (8,'/copyright','COPYRIGHT');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (9,'/hr','HR & TIMESHEET');

INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (21,'/viewUser','VIEW USER');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (22,'/editUser','EDIT USER');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (23,'/deleteUser','DELETE USER');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (24,'/resetUser','RESET USER');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (25,'/userWrites','USER WRITES');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (26,'/agents','AGENTS');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (27,'/deleteAgent','DELETE AGENT');


INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (31,'/viewCustomer','VIEW CUSTOMER');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (32,'/editCustomer','EDIT CUSTOMER');
INSERT INTO `kcpatel`.`navigation_master`(`navigation_master_id`, `navigation_url`, `display_name`)VALUES (33,'/deleteCustomer','DELETE CUSTOMER');
