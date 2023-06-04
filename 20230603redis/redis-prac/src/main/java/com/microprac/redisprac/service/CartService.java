package com.microprac.redisprac.service;

import com.microprac.redisprac.entity.Cart;
import com.microprac.redisprac.entity.CartItem;

import java.util.List;

public interface CartService {
    List<CartItem> getCartById(String cartKey);
}
