package com.osharedesigns.oshare_store.model.domain;

import com.osharedesigns.oshare_store.model.dto.request.dtoProduct_create;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "products")
@Entity(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String links;
    private BigDecimal price;
    private BigDecimal rating;
    private String from_country;
    private String material;
    private BigDecimal discount;
    private boolean inCatalogue;
    @CreatedDate
    @Column(updatable = false)
    private LocalDate addedAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Product(dtoProduct_create newProduct){
        this.name = newProduct.name();
        this.description = newProduct.description();
        this.links = newProduct.links();
        this.price = newProduct.price();
        this.rating = newProduct.rating();
        this.from_country = newProduct.from_country();
        this.material = newProduct.material();
    }

}
