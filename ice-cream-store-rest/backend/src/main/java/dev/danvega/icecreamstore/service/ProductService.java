package dev.danvega.icecreamstore.service;

import dev.danvega.icecreamstore.model.Category;
import dev.danvega.icecreamstore.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1,"Junior Scoop", new BigDecimal(3.35).setScale(2, RoundingMode.UP), Category.SCOOPS));
        products.add(new Product(2,"Single Scoop", new BigDecimal(4.35).setScale(2, RoundingMode.UP), Category.SCOOPS));
        products.add(new Product(3,"Taster's Duo", new BigDecimal(4.35).setScale(2, RoundingMode.UP), Category.SCOOPS));
        products.add(new Product(4,"Taster's Trio", new BigDecimal(5.95).setScale(2, RoundingMode.UP), Category.SCOOPS));
        products.add(new Product(5,"Double Scoop", new BigDecimal(5.35).setScale(2, RoundingMode.UP), Category.SCOOPS));
        products.add(new Product(6,"Triple Scoop", new BigDecimal(6.75).setScale(2, RoundingMode.UP), Category.SCOOPS));
    }

    public List<Product> list() {
        return products;
    }

    public List<Product> findByCategory(Category category) {
        return products.stream().filter( product -> product.getCategory() == category).collect(Collectors.toList());
    }

    public List<Product> findAll() {
        return products;
    }

}
