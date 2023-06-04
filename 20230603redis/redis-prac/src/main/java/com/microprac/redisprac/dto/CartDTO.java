package com.microprac.redisprac.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CartDTO {

    private Long cartId;

    private CartItem items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CartItem {
        private Long itemId;
        private Long skuId;
        private String attribute;
        private BigDecimal price;
        private Integer count;

    }


}
