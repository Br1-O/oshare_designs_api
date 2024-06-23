create table if not exists product_tags(
id BIGINT auto_increment PRIMARY KEY NOT NULL,
name VARCHAR(50) NOT NULL,
description VARCHAR(255),
discount_percentage DECIMAL(5,2)
);