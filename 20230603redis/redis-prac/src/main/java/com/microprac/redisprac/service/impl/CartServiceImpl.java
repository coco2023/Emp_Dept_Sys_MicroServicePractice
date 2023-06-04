package com.microprac.redisprac.service.impl;

import com.microprac.redisprac.entity.Cart;
import com.microprac.redisprac.entity.CartItem;
import com.microprac.redisprac.service.CartItemService;
import com.microprac.redisprac.service.CartService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CartServiceImpl implements CartService {

    @Autowired
    private CartItemService cartItemService;

    @Override
    public List<CartItem> getCartById(String cartKey) {
        log.info("this is Cart key: " + cartKey);
        List<CartItem> cart = cartItemService.list(cartKey);
        return cart;
    }
}
