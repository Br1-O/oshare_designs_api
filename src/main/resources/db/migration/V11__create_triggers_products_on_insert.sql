
DELIMITER //

CREATE PROCEDURE handle_product_novelty_tag_assign(IN product_id BIGINT, IN added_at DATE)
BEGIN
    DECLARE novelty_tag_id BIGINT;

    SET novelty_tag_id = 1;

    IF NOT EXISTS (
        SELECT 1 FROM products_tags_relation
        WHERE product_id = product_id AND tag_id = novelty_tag_id
    ) THEN
        IF DATEDIFF(CURRENT_DATE, added_at) <= 30 THEN
            INSERT INTO products_tags_relation(product_id, tag_id) VALUES (product_id, novelty_tag_id);
        END IF;
    END IF;
END //

CREATE PROCEDURE handle_product_discount_tag_assign(IN product_id BIGINT, IN discount DECIMAL)
BEGIN
    DECLARE discount_tag_id BIGINT;

    SET discount_tag_id = 2;

    IF NOT EXISTS (
        SELECT 1 FROM products_tags_relation
        WHERE product_id = product_id AND tag_id = discount_tag_id
    ) THEN
        IF discount !=0 THEN
            INSERT INTO products_tags_relation(product_id, tag_id) VALUES (product_id, discount_tag_id);
        END IF;
    END IF;
END //

CREATE PROCEDURE handle_product_special_offer_tag_assign(IN product_id BIGINT, IN special_offer TINYINT)
BEGIN
    DECLARE special_offer_tag_id BIGINT;

    SET special_offer_tag_id = 3;

    IF NOT EXISTS (
        SELECT 1 FROM products_tags_relation
        WHERE product_id = product_id AND tag_id = special_offer_tag_id
    ) THEN
        IF special_offer !=0 THEN
            INSERT INTO products_tags_relation(product_id, tag_id) VALUES (product_id, special_offer_tag_id);
        END IF;
    END IF;
END //


CREATE TRIGGER after_product_insert_novelty
AFTER INSERT ON products
FOR EACH ROW
BEGIN
    CALL handle_product_novelty_tag_assign(NEW.id, NEW.added_at);
END //

CREATE TRIGGER after_product_update_novelty
AFTER UPDATE ON products
FOR EACH ROW
BEGIN
    CALL handle_product_novelty_tag_assign(NEW.id, NEW.added_at);
END //


CREATE TRIGGER after_product_insert_discount
AFTER INSERT ON products
FOR EACH ROW
BEGIN
    CALL handle_product_discount_tag_assign(NEW.id, NEW.discount);
END //

CREATE TRIGGER after_product_update_discount
AFTER UPDATE ON products
FOR EACH ROW
BEGIN
    CALL handle_product_discount_tag_assign(NEW.id, NEW.discount);
END //


CREATE TRIGGER after_product_insert_special_offer
AFTER INSERT ON products
FOR EACH ROW
BEGIN
    CALL handle_product_special_offer_tag_assign(NEW.id, NEW.special_offer);
END //

CREATE TRIGGER after_product_update_special_offer
AFTER UPDATE ON products
FOR EACH ROW
BEGIN
    CALL handle_product_special_offer_tag_assign(NEW.id, NEW.special_offer);
END //

DELIMITER ;
