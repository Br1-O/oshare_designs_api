create table if not exists products_tags_relation(
id BIGINT auto_increment PRIMARY KEY NOT NULL,
product_id BIGINT(30) NOT NULL,
tag_id BIGINT(30) NOT NULL,
FOREIGN KEY (product_id) REFERENCES products(id),
FOREIGN KEY (tag_id) REFERENCES product_tags(id)
);