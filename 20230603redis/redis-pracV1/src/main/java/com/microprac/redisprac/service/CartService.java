package com.microprac.redisprac.service;

import com.microprac.redisprac.dto.CartDTO;

import java.util.List;

public interface CartService {
    void saveItem(CartDTO cartDTO);

    CartDTO getCartById(Long cartId);

    List<CartDTO> getAll();
}
