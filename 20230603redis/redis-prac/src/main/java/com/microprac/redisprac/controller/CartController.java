package com.microprac.redisprac.controller;

import com.microprac.redisprac.constant.RedisConstant;
import com.microprac.redisprac.entity.Cart;
import com.microprac.redisprac.entity.CartItem;
import com.microprac.redisprac.service.CartService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart/v1/carts")
@Log4j2
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{cartId}")
    public ResponseEntity<List<CartItem>> getCartById(@PathVariable("cartId") Long cartId) {
        String cartKey = RedisConstant.CART_PREFIX + cartId;
        List<CartItem> cart = cartService.getCartById(cartKey);
        log.info("successfully get cart info!");
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

}
