package com.microprac.redisprac.entity;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@RedisHash("Cart")

public class Cart implements Serializable {

    private static final long serialVersionID = 7156526077883281623L;

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    private Long productId;

    private String productName;
    private int quantity;

}
