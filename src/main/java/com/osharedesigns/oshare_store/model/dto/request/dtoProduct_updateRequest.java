package com.osharedesigns.oshare_store.model.dto.request;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record dtoProduct_updateRequest(
        @NotNull
        long id,
        String name,
        String description,
        String links,
        BigDecimal price,
        BigDecimal rating,
        String from_country,
        String material,
        BigDecimal discount,
        boolean in_catalogue,
        String image_url,
        String tags,
        String categories
) {
}
