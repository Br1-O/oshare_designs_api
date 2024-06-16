create table if not exists products_tags_relation(
id int auto_increment PRIMARY KEY NOT NULL,
product_id int(30) NOT NULL,
tag_id int(30) NOT NULL,
FOREIGN KEY (product_id) REFERENCES products(id),
FOREIGN KEY (tag_id) REFERENCES product_tags(id)
);