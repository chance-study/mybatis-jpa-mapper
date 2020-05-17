CREATE TABLE `cron`  (
  `cron_id` varchar(30) NOT NULL PRIMARY KEY,
  `cron` varchar(30) NOT NULL
);

CREATE TABLE `user_info`  (
  `user_name` varchar(30) NOT NULL PRIMARY KEY,
  `mobile` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `passwd` varchar(30) NOT NULL,
  `valid` varchar(30) NOT NULL
);