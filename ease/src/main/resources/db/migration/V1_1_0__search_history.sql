CREATE TABLE `search_history` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`user` varchar(255) COLLATE utf8_slovak_ci NOT NULL,
	`time` timestamp NOT NULL,
	`searched_expression` varchar(255) COLLATE utf8_slovak_ci NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_slovak_ci	

