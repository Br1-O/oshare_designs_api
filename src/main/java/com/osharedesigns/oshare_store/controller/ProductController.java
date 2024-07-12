package com.osharedesigns.oshare_store.controller;

import com.osharedesigns.oshare_store.model.domain.Product;
import com.osharedesigns.oshare_store.model.dto.request.dtoProduct_createRequest;
import com.osharedesigns.oshare_store.model.dto.request.dtoProduct_updateRequest;
import com.osharedesigns.oshare_store.model.dto.response.dtoProductFullData_response;
import com.osharedesigns.oshare_store.model.repositories.IProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/productos")
public class ProductController {


    //dependency injection via constructor
    private final IProductRepository productRepository;
    public ProductController(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //create method
    @PostMapping("/agregar")
    public ResponseEntity<dtoProductFullData_response> create(@RequestBody dtoProduct_createRequest dtoProduct_createRequest, UriComponentsBuilder UriComponentsBuilder){

        Product newProduct = productRepository.save(new Product(dtoProduct_createRequest));

        dtoProductFullData_response dtoProductFullData_response = new dtoProductFullData_response(newProduct);

        URI url = UriComponentsBuilder.path("/productos/{id}").buildAndExpand(newProduct.getId()).toUri();

        return ResponseEntity.created(url).body(dtoProductFullData_response);
    }

    //READ ALL method
    @GetMapping("/todos")
    public ResponseEntity<Page<dtoProductFullData_response>> showAll(@PageableDefault(size = 4, sort="name") Pageable pagination){

        Page<Product> productsList = productRepository.findByInCatalogueTrue(pagination);

        return ResponseEntity.ok(productsList.map(dtoProductFullData_response::new));
    }


    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<dtoProductFullData_response> showOne(@PathVariable long id){

        Product product = productRepository.getReferenceById(id);

        dtoProductFullData_response dtoProductFullData_response = new dtoProductFullData_response(product);

        return ResponseEntity.ok(dtoProductFullData_response);
    }

    //LOGICAL DELETE method, sets "inCatalogue" as false
    @DeleteMapping("/borrar")
    //@Secured("ROLE_ADMIN")
    @Transactional
    public ResponseEntity delete(@RequestParam long id){
        //get reference of product by id from db
        Product product = productRepository.getReferenceById(id);
        //set inCatalogue as false
        product.setInCatalogue(false);

        return ResponseEntity.noContent().build();
    }

    //UPDATE method
    @PutMapping("/editar")
    @Transactional
    public ResponseEntity<dtoProductFullData_response> edit(@RequestParam long id, @RequestBody dtoProduct_updateRequest dtoProduct_updateRequest){
        //get reference of product by id from db
        Product product = productRepository.getReferenceById(id);
        //use update method from Product class passing the dtoProduct_updateRequest as parameter
        product.updateData(dtoProduct_updateRequest);

        dtoProductFullData_response dtoProductFullData_response = new dtoProductFullData_response(product);

        return ResponseEntity.ok(dtoProductFullData_response);
    }
}
