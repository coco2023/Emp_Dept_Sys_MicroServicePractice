package com.microprac.redisprac.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CartDTO {

    private Long productId;

    private String productName;
    private int quantity;

}
