package com.example.capas_cart.repository;

import com.example.capas_cart.model.Product;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class CartRepository {

    private final Map<Long, Product> products = new HashMap<>();
    private Long currentId = 1L;

    public Product save(String name, double price) {
        Product product = new Product(currentId++, name, price);
        products.put(product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public void deleteById(Long id) {
        products.remove(id);
    }

    public void clear() {
        products.clear();
    }

    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : products.values()) {
            if (p.getName().equalsIgnoreCase(name)) {
                result.add(p);
            }
        }
        return result;
    }
}