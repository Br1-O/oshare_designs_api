package com.osharedesigns.oshare_store.model.domain;

import com.osharedesigns.oshare_store.model.dto.request.dtoProduct_createRequest;
import com.osharedesigns.oshare_store.model.dto.request.dtoProduct_updateRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
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
    private String tags;
    private String categories;
    private String image_url;
    private boolean inCatalogue;

    @CreatedDate
    @Column(updatable = false)
    private LocalDate addedAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        if (this.addedAt == null) {
            this.addedAt = LocalDate.now();
        }

        if (!this.inCatalogue) {
            this.inCatalogue = true;
        }

        if (this.from_country == null) {
            this.from_country = "Argentina";
        }
    }

    public Product(dtoProduct_createRequest newProduct){
        this.name = newProduct.name();
        this.description = newProduct.description();
        this.links = newProduct.links();
        this.price = newProduct.price();
        this.rating = newProduct.rating();
        this.from_country = newProduct.from_country();
        this.material = newProduct.material();
        this.discount = newProduct.discount();
        this.tags = newProduct.tags();
        this.categories = newProduct.categories();
        this.image_url = newProduct.image_url();
    }

    public void updateData(dtoProduct_updateRequest dtoProduct_updateRequest){

        if(dtoProduct_updateRequest.name()!=null){
            this.setName(dtoProduct_updateRequest.name());
        }
        if(dtoProduct_updateRequest.description()!=null){
            this.setDescription(dtoProduct_updateRequest.description());
        }
        if(dtoProduct_updateRequest.links()!=null){
            this.setLinks(dtoProduct_updateRequest.links());
        }
        if(dtoProduct_updateRequest.price()!=null){
            this.setPrice(dtoProduct_updateRequest.price());
        }
        if(dtoProduct_updateRequest.rating()!=null){
            this.setRating(dtoProduct_updateRequest.rating());
        }
        if(dtoProduct_updateRequest.from_country()!=null){
            this.setFrom_country(dtoProduct_updateRequest.from_country());
        }
        if(dtoProduct_updateRequest.material()!=null){
            this.setMaterial(dtoProduct_updateRequest.material());
        }
        if(dtoProduct_updateRequest.discount()!=null){
            this.setDiscount(dtoProduct_updateRequest.discount());
        }
        if(dtoProduct_updateRequest.tags()!=null){
            this.setTags(dtoProduct_updateRequest.tags());
        }
        if(dtoProduct_updateRequest.categories()!=null){
            this.setCategories(dtoProduct_updateRequest.categories());
        }
        if(dtoProduct_updateRequest.image_url()!=null){
            this.setImage_url(dtoProduct_updateRequest.image_url());
        }
    }

}
