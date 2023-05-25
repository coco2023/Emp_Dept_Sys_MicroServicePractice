package com.microprac.productservice.service.impl;

import com.microprac.productservice.entity.Product;
import com.microprac.productservice.exception.ProductServiceException;
import com.microprac.productservice.model.ProductRequest;
import com.microprac.productservice.model.ProductResponse;
import com.microprac.productservice.repository.ProductRepository;
import com.microprac.productservice.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {
        log.info("adding products...");

        Product product = Product.builder()
                .productName(productRequest.getProductName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

//                .productName("laptop")
//                .quantity(10l)
//                .price(1000l)
//                .build();

        productRepository.save(product);
        ProductResponse productResponse = new ProductResponse();
        copyProperties(product, productResponse);

        return productResponse;
    }

    @Override
    public ProductResponse getProductById(Long productId) {
        Product product = productRepository.findById(productId)
//                .get()
//                .orElseThrow(() -> new RuntimeException("Product does not exist"));
                .orElseThrow(() -> new ProductServiceException(
                        "productId - " + productId + " does not exist!",
                        "PRODUCT_NOT_FOUND"));
        ProductResponse productResponse = new ProductResponse();
        copyProperties(product, productResponse);                       // static import

        return productResponse;
    }
}
