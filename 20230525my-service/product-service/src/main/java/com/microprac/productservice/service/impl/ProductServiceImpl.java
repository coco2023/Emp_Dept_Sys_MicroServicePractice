package com.microprac.productservice.service.impl;

import com.microprac.productservice.entity.Product;
import com.microprac.productservice.model.ProductRequest;
import com.microprac.productservice.model.ProductResponse;
import com.microprac.productservice.repository.ProductRepository;
import com.microprac.productservice.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Long addProduct(ProductRequest productRequest) {
        log.info("adding products...");

        Product product = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuality())
                .price(productRequest.getPrice())
                .build();

//                .productName("laptop")
//                .quantity(10l)
//                .price(1000l)
//                .build();

        productRepository.save(product);
        return product.getProductId();
    }
}
