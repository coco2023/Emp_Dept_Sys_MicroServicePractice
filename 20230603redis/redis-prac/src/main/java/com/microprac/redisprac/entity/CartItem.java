package com.microprac.redisprac.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Accessors(chain = true)
//@RedisHash("CartItem")

public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long skuId;

    private Integer count;

    private Boolean isChecked;

}
