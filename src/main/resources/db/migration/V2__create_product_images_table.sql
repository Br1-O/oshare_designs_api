create table if not exists product_images(
id BIGINT auto_increment PRIMARY KEY NOT NULL,
url VARCHAR(200) NOT NULL,
product_id BIGINT NOT NULL,
FOREIGN KEY (product_id) REFERENCES products(id)
);