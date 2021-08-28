package dev.danvega.icecreamstore.controller;

import dev.danvega.icecreamstore.model.Product;
import dev.danvega.icecreamstore.service.ProductService;
import dev.danvega.icecreamstore.service.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
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
        return true;
    }

}
