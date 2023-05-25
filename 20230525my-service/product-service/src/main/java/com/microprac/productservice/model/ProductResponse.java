package com.microprac.productservice.model;

import lombok.Data;

@Data
public class ProductResponse {
    private Long productId;

    private String productName;

    private Long price;

}
