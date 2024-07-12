package com.osharedesigns.oshare_store.model.repositories;

import com.osharedesigns.oshare_store.model.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByInCatalogueTrue(Pageable pagination);
}
