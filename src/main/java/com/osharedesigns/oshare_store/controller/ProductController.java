package com.osharedesigns.oshare_store.controller;

import com.osharedesigns.oshare_store.model.domain.Product;
import com.osharedesigns.oshare_store.model.dto.response.dtoProductFullData_read;
import com.osharedesigns.oshare_store.model.dto.response.dtoProduct_read;
import com.osharedesigns.oshare_store.model.repositories.IProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductController {


    //dependency injection via constructor

    private final IProductRepository productRepository;

    public ProductController(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //READ ALL method
    @GetMapping("/mostrar")
    public ResponseEntity<Page<dtoProduct_read>> show(@PageableDefault(size = 4, sort="name") Pageable pagination){

        return ResponseEntity.ok(productRepository.findByInCatalogueTrue(pagination).map(dtoProduct_read::new));
    }

    @GetMapping("/mostrar/{id}")
    @Transactional
    public ResponseEntity<dtoProductFullData_read> showOne(@PathVariable long id){

        Object[] result = productRepository.getProductFullData(id);

        Object[] productData = (Object[]) result[0];

        dtoProductFullData_read dtoProductFullData_read = new dtoProductFullData_read(productData);

        return ResponseEntity.ok(dtoProductFullData_read);
    }

}
