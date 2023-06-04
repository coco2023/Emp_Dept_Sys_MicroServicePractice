package com.microprac.redisprac.service.impl;

import com.microprac.redisprac.dto.CartDTO;
import com.microprac.redisprac.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private HttpSession httpSession;

    @Override
    public void saveItem(CartDTO cartDTO) {
        redisTemplate.opsForHash().put(httpSession.getId(), cartDTO.getProductId(), cartDTO);
    }

    @Override
    public CartDTO getCartById(Long cartId) {
        return null;
    }

    @Override
    public List<CartDTO> getAll() {
        return redisTemplate.opsForHash().values(httpSession.getId());
    }
}
