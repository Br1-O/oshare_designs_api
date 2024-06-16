create table if not exists product_images(
id int auto_increment PRIMARY KEY NOT NULL,
url VARCHAR(200) NOT NULL,
product_id int(50) NOT NULL UNIQUE,
FOREIGN KEY (product_id) REFERENCES products(id)
);