DELIMITER //

CREATE PROCEDURE getProductsListFullData()
BEGIN
    SELECT
        p.id,
        p.name,
        p.description,
        p.links,
        p.price,
        p.rating,
        p.from_country,
        p.material,
        p.discount,
        p.in_catalogue,
        p.added_at,
        p.updated_at,
        CONCAT('[', GROUP_CONCAT(DISTINCT CONCAT('"', i.url, '"') SEPARATOR ', '), ']') AS image_url,
        CONCAT('[', GROUP_CONCAT(DISTINCT CONCAT('"', t.name, '"') SEPARATOR ', '), ']') AS tags,
        CONCAT('[', GROUP_CONCAT(DISTINCT CONCAT('"', c.name, '"') SEPARATOR ', '), ']') AS categories
    FROM
        products p
    LEFT JOIN
        product_images i ON p.id = i.product_id
    LEFT JOIN
        products_tags_relation pt ON p.id = pt.product_id
    LEFT JOIN
        product_tags t ON pt.tag_id = t.id
    LEFT JOIN
        products_categories_relation pc ON p.id = pc.product_id
    LEFT JOIN
        product_categories c ON pc.category_id = c.id
    GROUP BY
        p.id, p.name, p.description, p.links, p.price, p.rating, p.from_country, p.material, p.discount, p.in_catalogue;
END //

CREATE PROCEDURE getSingleProductFullData(IN productId BIGINT)
BEGIN
    SELECT
        p.id,
        p.name,
        p.description,
        p.links,
        p.price,
        p.rating,
        p.from_country,
        p.material,
        p.discount,
        p.in_catalogue,
        p.added_at,
        p.updated_at,
        CONCAT('[', GROUP_CONCAT(DISTINCT CONCAT('"', i.url, '"') SEPARATOR ', '), ']') AS image_url,
        CONCAT('[', GROUP_CONCAT(DISTINCT CONCAT('"', t.name, '"') SEPARATOR ', '), ']') AS tags,
        CONCAT('[', GROUP_CONCAT(DISTINCT CONCAT('"', c.name, '"') SEPARATOR ', '), ']') AS categories
    FROM
        products p
    LEFT JOIN
        product_images i ON p.id = i.product_id
    LEFT JOIN
        products_tags_relation pt ON p.id = pt.product_id
    LEFT JOIN
        product_tags t ON pt.tag_id = t.id
    LEFT JOIN
        products_categories_relation pc ON p.id = pc.product_id
    LEFT JOIN
        product_categories c ON pc.category_id = c.id
    WHERE
        p.id = productId
    GROUP BY
        p.id, p.name, p.description, p.links, p.price, p.rating, p.from_country, p.material, p.discount, p.in_catalogue;
END //
DELIMITER ;