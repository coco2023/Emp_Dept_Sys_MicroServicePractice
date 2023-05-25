package com.microprac.productservice.controller;

import com.microprac.productservice.entity.Product;
import com.microprac.productservice.model.ProductRequest;
import com.microprac.productservice.model.ProductResponse;
import com.microprac.productservice.service.ProductService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct (@RequestBody ProductRequest productRequest) {
        Long id = productService.addProduct(productRequest);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

}
