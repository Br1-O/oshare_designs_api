create table if not exists products_categories_relation(
id int auto_increment PRIMARY KEY NOT NULL,
product_id int(30) NOT NULL,
category_id int(30) NOT NULL,
FOREIGN KEY (product_id) REFERENCES products(id),
FOREIGN KEY (category_id) REFERENCES product_categories(id)
);