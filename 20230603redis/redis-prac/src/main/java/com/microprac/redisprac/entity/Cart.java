package com.microprac.redisprac.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
//@Accessors(chain = true)
//@RedisHash("Cart")

public class Cart implements Serializable {

    private static final long serialVersionID = 7156526077883281623L;

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    private Long cartId;

//    private CartItem items;
//
//    @Data
//    @NoArgsConstructor
//    @AllArgsConstructor
//    @Builder
//    public static class CartItem {
//        private Long itemId;
//        private Long skuId;
//        private String attribute;
//        private BigDecimal price;
//        private Integer count;
//
//    }
}
