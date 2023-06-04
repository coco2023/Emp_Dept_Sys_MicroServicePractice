package com.microprac.redisprac.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CartItemDTO {

    private Long skuId;
    private Integer count;
    private Boolean isCheck;

}
