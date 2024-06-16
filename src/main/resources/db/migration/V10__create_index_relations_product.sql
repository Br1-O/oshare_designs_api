CREATE INDEX idx_relation_product_category_product ON products_categories_relation(product_id);
CREATE INDEX idx_relation_product_category_category ON products_categories_relation(category_id);

CREATE INDEX idx_relation_product_tag_product ON products_tags_relation(product_id);
CREATE INDEX idx_relation_product_tag_tag ON products_tags_relation(tag_id);