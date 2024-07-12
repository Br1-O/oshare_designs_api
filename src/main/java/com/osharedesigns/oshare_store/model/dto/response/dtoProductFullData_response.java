package com.osharedesigns.oshare_store.model.dto.response;

import com.osharedesigns.oshare_store.model.domain.Product;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record dtoProductFullData_response(
        Long id,
        String name,
        String description,
        String links,
        BigDecimal price,
        BigDecimal rating,
        String from_country,
        String material,
        BigDecimal discount,
        boolean in_catalogue,
        LocalDate added_at,
        LocalDateTime updated_at,
        String image_url,
        String tags,
        String categories){

    public dtoProductFullData_response(Product product){
            this(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getLinks(),
                product.getPrice(),
                product.getRating(),
                product.getFrom_country(),
                product.getMaterial(),
                product.getDiscount(),
                product.isInCatalogue(),
                product.getAddedAt(),
                product.getUpdatedAt(),
                product.getImage_url(),
                product.getTags(),
                product.getCategories()
            );
    }

}
