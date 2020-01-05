CREATE TABLE `drinks` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `image` text NOT NULL,
  `type` ENUM ('can', 'pet') NOT NULL,
  `capacity` int NOT NULL,
  `price` int NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp on update current_timestamp
);

CREATE TABLE `temperatures` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `value` ENUM ('cold', 'hot', 'normal') UNIQUE NOT NULL
);

CREATE TABLE `drinks_temperatures` (
  `drink_id` int NOT NULL,
  `temperature_id` int NOT NULL,
  PRIMARY KEY (`drink_id`, `temperature_id`)
);

CREATE TABLE `vending_machine_items` (
  `row_column` varchar(255) PRIMARY KEY,
  `row` int NOT NULL,
  `column` int NOT NULL,
  `vending_storehouse_drink_id` int NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp on update current_timestamp
);

CREATE TABLE `vending_storehouse_drinks` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `drink_id` int NOT NULL,
  `temperature_id` int NOT NULL,
  `amount` int NOT NULL DEFAULT 0,
  `status` ENUM ('sold_out', 'progress', 'on_sale') NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp on update current_timestamp
);

CREATE TABLE `sells` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `drink_id` int NOT NULL,
  `temperature_id` int NOT NULL,
  `sold_at` datetime NOT NULL DEFAULT current_timestamp,
  `is_payment` boolean NOT NULL DEFAULT true
);

ALTER TABLE `drinks_temperatures` ADD FOREIGN KEY (`drink_id`) REFERENCES `drinks` (`id`);

ALTER TABLE `drinks_temperatures` ADD FOREIGN KEY (`temperature_id`) REFERENCES `temperatures` (`id`);

ALTER TABLE `vending_machine_items` ADD FOREIGN KEY (`vending_storehouse_drink_id`) REFERENCES `vending_storehouse_drinks` (`id`);

ALTER TABLE `vending_storehouse_drinks` ADD FOREIGN KEY (`drink_id`) REFERENCES `drinks` (`id`);

ALTER TABLE `vending_storehouse_drinks` ADD FOREIGN KEY (`temperature_id`) REFERENCES `temperatures` (`id`);

ALTER TABLE `sells` ADD FOREIGN KEY (`drink_id`) REFERENCES `drinks` (`id`);

ALTER TABLE `sells` ADD FOREIGN KEY (`temperature_id`) REFERENCES `temperatures` (`id`);

CREATE UNIQUE INDEX `vending_machine_items_index_0` ON `vending_machine_items` (`row`, `column`);

CREATE UNIQUE INDEX `vending_storehouse_drink_index_0` ON `vending_storehouse_drinks` (`drink_id`, `temperature_id`);

INSERT IGNORE INTO `temperatures`(value) values ('cold');
INSERT IGNORE INTO `temperatures`(value) values ('hot');
INSERT IGNORE INTO `temperatures`(value) values ('normal');