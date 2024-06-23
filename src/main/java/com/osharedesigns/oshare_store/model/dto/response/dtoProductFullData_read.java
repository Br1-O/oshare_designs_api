package com.osharedesigns.oshare_store.model.dto.response;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public record dtoProductFullData_read(
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

    public dtoProductFullData_read(Object[] product){
            this(
                (Long) product[0],
                (String) product[1],
                (String) product[2],
                (String) product[3],
                (BigDecimal) product[4],
                (BigDecimal) product[5],
                (String) product[6],
                (String) product[7],
                (BigDecimal) product[8],
                (Boolean) product[9],
                toLocalDate((Date) product[10]),
                toLocalDateTime((Timestamp) product[11]),
                product[12].toString(),
                product[13].toString(),
                product[14].toString()
            );
    }

    private static LocalDate toLocalDate(Date date) {
        return date.toLocalDate();
    }

    private static LocalDateTime toLocalDateTime(Timestamp timestamp) {
        return LocalDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault());
    }

}
