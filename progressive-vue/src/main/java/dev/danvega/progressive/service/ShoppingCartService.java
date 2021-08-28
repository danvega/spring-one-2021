package dev.danvega.progressive.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartService {

    private Map<Integer,Integer> cart = new HashMap<>();

    public Integer getCartCount() {
        return cart.values().stream().reduce(0, Integer::sum);
    }

    public void addToCart(Integer id) {
        if(cart.containsKey(id) ) {
            var currentQty = cart.get(id).intValue();
            cart.replace(id,currentQty+1);
        } else {
            cart.put(id,1);
        }
    }

    public Map<Integer,Integer> findAll() {
        return cart;
    }

}
