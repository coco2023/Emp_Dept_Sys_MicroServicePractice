package com.microprac.redisprac.service;

import com.microprac.redisprac.dto.CartItemDTO;
import com.microprac.redisprac.entity.CartItem;

import java.util.List;

public interface CartItemService {
    void save(CartItemDTO cartItemDTO, String cartKey);

    List<CartItem> list(String cartKey);
}
