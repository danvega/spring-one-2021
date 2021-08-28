package dev.danvega.progressive.controller;

import dev.danvega.progressive.model.Product;
import dev.danvega.progressive.service.ProductService;
import dev.danvega.progressive.service.ShoppingCartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {

    private final ProductService productService;
    private final ShoppingCartService cartService;

    public ShoppingCartController(ProductService productService, ShoppingCartService cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    @PostMapping
    public boolean addToCart(@RequestBody Product product) throws InterruptedException {
        cartService.addToCart(product.getId());
        Thread.sleep(4000);
        return true;
    }

}
