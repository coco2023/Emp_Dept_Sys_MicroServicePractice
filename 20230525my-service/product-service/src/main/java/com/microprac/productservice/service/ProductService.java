package com.microprac.productservice.service;

import com.microprac.productservice.model.ProductRequest;
import com.microprac.productservice.model.ProductResponse;

public interface ProductService {

    public Long addProduct(ProductRequest productRequest);
}
