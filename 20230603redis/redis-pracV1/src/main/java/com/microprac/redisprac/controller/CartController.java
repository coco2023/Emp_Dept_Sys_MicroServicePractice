package com.microprac.redisprac.controller;

import com.alibaba.fastjson.JSON;
import com.microprac.redisprac.dto.CartDTO;
import com.microprac.redisprac.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cart/v1")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping()
    public ResponseEntity<Void> saveItem(@RequestBody CartDTO cartDTO) {
        cartService.saveItem(cartDTO);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<CartDTO> getCartById(@PathVariable("cartId") Long cartId) {
        CartDTO cartDTO = cartService.getCartById(cartId);
        return new ResponseEntity<>(cartDTO, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CartDTO>> getAll() {
        List<CartDTO> cartDTOList = cartService.getAll()
                                            .stream()
                                            .map(String::valueOf)
                                            .map(json -> JSON.parseObject(json, CartDTO.class))
                                            .collect(Collectors.toList());

        return new ResponseEntity<>(cartDTOList, HttpStatus.OK);
    }

}
