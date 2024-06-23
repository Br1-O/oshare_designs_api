create table if not exists product_categories(
id BIGINT auto_increment PRIMARY KEY NOT NULL,
name VARCHAR(35) NOT NULL,
description VARCHAR(255)
);