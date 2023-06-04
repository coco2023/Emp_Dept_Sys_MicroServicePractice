package com.microprac.redisprac.service.impl;

import com.alibaba.fastjson.JSON;
import com.microprac.redisprac.dto.CartItemDTO;
import com.microprac.redisprac.entity.CartItem;
import com.microprac.redisprac.service.CartItemService;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private StringRedisTemplate strRedisTemp;

    @Override
    public void save(CartItemDTO cartItemDTO, String cartKey) {

        var skuId = cartItemDTO.getSkuId();
        var cartItem = new CartItem()
                .setSkuId(skuId)
                .setCount(1000)
                .setIsChecked(false);

        log.info("cartKey:" + cartKey + " cartItem: " + cartItem);

        // BoundHashOperations <java.lang.String, java.lang.Object,java.lang.Object>
        strRedisTemp.boundHashOps(cartKey).put(
                cartItem.getSkuId().toString(),
                JSON.toJSONString(cartItem)
        );

    }

    @Override
    public List<CartItem> list(String cartKey) {

        List<CartItem> cartItemList = strRedisTemp.boundHashOps(cartKey).values()
                .stream()
                .map(String::valueOf)
                .map(json -> JSON.parseObject(json, CartItem.class))
                .collect(Collectors.toList()
        );

        return cartItemList;
    }

    @Override
    public List<CartItem> getSelectedItem(String cartKey) {
        List<CartItem> cartItemSelectedList = strRedisTemp.boundHashOps(cartKey).values()
                .stream()
                .map(String::valueOf)
                .map(json -> JSON.parseObject(json, CartItem.class))
                .filter(CartItem::getIsChecked)
                .collect(Collectors.toList());

        return cartItemSelectedList;
    }

    @Override
    public void deleteBySkuId(Long skuId, String cartKey) {
        strRedisTemp.boundHashOps(cartKey).delete(skuId.toString());
        log.info("Delete Succesfully!");
    }

}
