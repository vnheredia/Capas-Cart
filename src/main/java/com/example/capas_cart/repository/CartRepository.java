package com.example.capas_cart.repository;

import com.example.capas_cart.model.Product;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class CartRepository {

    private final Map<Long, Product> products = new HashMap<>();
    private Long currentId = 1L;

    public Product save(String name, double price) {
        Product p = new Product(currentId++, name, price);
        products.put(p.getId(), p);
        return p;
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public void update(Long id, String name, double price) {
        products.put(id, new Product(id, name, price));
    }

    public void delete(Long id) {
        products.remove(id);
    }

    public void clear() {
        products.clear();
    }
}