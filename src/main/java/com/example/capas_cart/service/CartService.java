package com.example.capas_cart.service;

import com.example.capas_cart.model.Product;
import com.example.capas_cart.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository repo;

    public CartService(CartRepository repo) {
        this.repo = repo;
    }

    public String add(String name, double price) {
        if (name.isBlank() || price <= 0) return "Datos inválidos";
        repo.save(name, price);
        return "Producto agregado";
    }

    public List<Product> list() {
        return repo.findAll();
    }

    public String update(Long id, String name, double price) {
        if (repo.findById(id).isEmpty()) return "No existe";
        repo.update(id, name, price);
        return "Actualizado";
    }

    public String delete(Long id) {
        repo.delete(id);
        return "Eliminado";
    }

    public void clear() {
        repo.clear();
    }

    public double total() {
        double total = repo.findAll().stream()
                .mapToDouble(Product::getPrice)
                .sum();

        if (total > 50) total *= 0.9;
        return total;
    }

    // 💳 Checkout
    public String checkout() {
        double total = total();
        repo.clear();
        return "Pago realizado. Total: $" + total;
    }
}