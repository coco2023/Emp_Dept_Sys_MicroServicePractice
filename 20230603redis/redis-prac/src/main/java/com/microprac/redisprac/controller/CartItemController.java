package com.microprac.redisprac.controller;

import com.microprac.redisprac.constant.RedisConstant;
import com.microprac.redisprac.dto.CartDTO;
import com.microprac.redisprac.dto.CartItemDTO;
import com.microprac.redisprac.entity.CartItem;
import com.microprac.redisprac.service.CartItemService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart/v1/cartItems")
@Log4j2
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public void save(@RequestBody CartItemDTO cartItemDTO, @RequestParam(value = "id") Long id) {
//        double id = Math.random();
        String cartKey = RedisConstant.CART_PREFIX + id;
        log.info("cartKey: " + cartKey + " cartItemController cartItemDTO: " + cartItemDTO.toString());
        cartItemService.save(cartItemDTO, cartKey);
        log.info("Successfully save the cartItem!");
    }

    @GetMapping()
    public ResponseEntity<List<CartItem>> getSelectedItem(@RequestParam(value = "id") Long id){
        String cartKey = RedisConstant.CART_PREFIX + id;
        log.info("cartKey: " + cartKey);
        List<CartItem> cartItemSelected = cartItemService.getSelectedItem(cartKey);

        return new ResponseEntity<>(cartItemSelected, HttpStatus.OK);
    }

    // get all cartItems --> get cart::number

    @DeleteMapping("/sku/{skuId}")
    public void deleteItem(@PathVariable("skuId") Long skuId, @RequestParam("id") Long cartId) {
        String cartKey = RedisConstant.CART_PREFIX + cartId;
        log.info("cartKey: " + cartKey);

        cartItemService.deleteBySkuId(skuId, cartKey);
    }
}
