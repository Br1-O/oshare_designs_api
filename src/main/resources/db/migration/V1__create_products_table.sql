create table if not exists products(
id int auto_increment PRIMARY KEY NOT NULL,
name VARCHAR(50) NOT NULL,
description VARCHAR(500),
links VARCHAR(255) NOT NULL,
price DECIMAL(10, 2) NOT NULL,
rating DECIMAL(2,1) NOT NULL DEFAULT 0.0,
from_country VARCHAR(50) DEFAULT "Argentina",
material VARCHAR(100)
);