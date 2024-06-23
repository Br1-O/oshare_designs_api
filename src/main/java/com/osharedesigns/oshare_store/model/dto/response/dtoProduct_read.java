package com.osharedesigns.oshare_store.model.dto.response;

import com.osharedesigns.oshare_store.model.domain.Product;

import java.math.BigDecimal;

public record dtoProduct_read(
        Long id,
        String name,
        String description,
        String links,
        BigDecimal price,
        BigDecimal rating,
        String from_country,
        String material){

    public dtoProduct_read(Product product){
        this(product.getId(), product.getName(), product.getDescription(), product.getLinks(),
                product.getPrice(), product.getRating(), product.getFrom_country(), product.getMaterial());
    }
}
