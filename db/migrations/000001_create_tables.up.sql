CREATE TABLE `drinks` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `image` text NOT NULL,
  `type` ENUM ('can', 'pet') NOT NULL,
  `capacity` int NOT NULL,
  `price` int unsigned NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp on update current_timestamp
);

CREATE TABLE `drink_temperature` (
  `drink_id` int NOT NULL,
  `temperature` ENUM ('cold', 'hot', 'normal') NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp on update current_timestamp
);

CREATE TABLE `vending_machine` (
  `row` int NOT NULL,
  `column` int NOT NULL,
  `vending_storehouse_drink_id` int NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp on update current_timestamp
);

CREATE TABLE `vending_storehouse_drink` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `drink_id` int NOT NULL,
  `temperature` ENUM ('cold', 'hot', 'normal'),
  `amount` int unsigned NOT NULL DEFAULT 0,
  `status` ENUM ('sold_out', 'progress', 'on_sale') NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp on update current_timestamp
);

CREATE TABLE `sells` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `drink_id` int NOT NULL,
  `temperature` ENUM ('cold', 'hot', 'normal') NOT NULL,
  `sold_at` datetime NOT NULL DEFAULT current_timestamp,
  `is_payment` boolean NOT NULL DEFAULT true
);

ALTER TABLE `drink_temperature` ADD FOREIGN KEY (`drink_id`) REFERENCES `drinks` (`id`);

ALTER TABLE `vending_machine` ADD FOREIGN KEY (`vending_storehouse_drink_id`) REFERENCES `vending_storehouse_drink` (`id`);

ALTER TABLE `vending_storehouse_drink` ADD FOREIGN KEY (`drink_id`) REFERENCES `drinks` (`id`);

ALTER TABLE `sells` ADD FOREIGN KEY (`drink_id`) REFERENCES `drinks` (`id`);

CREATE UNIQUE INDEX `drink_temperature_index_0` ON `drink_temperature` (`drink_id`, `temperature`);

CREATE UNIQUE INDEX `vending_machine_index_1` ON `vending_machine` (`row`, `column`);

CREATE UNIQUE INDEX `vending_storehouse_drink_index_2` ON `vending_storehouse_drink` (`drink_id`, `temperature`);
