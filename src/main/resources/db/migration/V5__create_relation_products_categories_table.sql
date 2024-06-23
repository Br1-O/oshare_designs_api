create table if not exists products_categories_relation(
id BIGINT auto_increment PRIMARY KEY NOT NULL,
product_id BIGINT NOT NULL,
category_id BIGINT NOT NULL,
FOREIGN KEY (product_id) REFERENCES products(id),
FOREIGN KEY (category_id) REFERENCES product_categories(id)
);