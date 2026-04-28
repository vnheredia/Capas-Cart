package com.example.capas_cart.service;

import com.example.capas_cart.model.Product;
import com.example.capas_cart.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository repository;

    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    public String addProduct(String name, double price) {
        if (name == null || name.isBlank()) {
            return "Nombre inválido";
        }

        if (price <= 0) {
            return "Precio inválido";
        }

        repository.save(name, price);
        return "Producto agregado";
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public double calculateTotal() {
        double total = 0;

        for (Product p : repository.findAll()) {
            total += p.getPrice();
        }

        // regla de negocio
        if (total > 50) {
            total *= 0.9;
        }

        return total;
    }

    public String deleteProduct(Long id) {
        if (repository.findById(id).isEmpty()) {
            return "Producto no encontrado";
        }

        repository.deleteById(id);
        return "Producto eliminado";
    }

    public String clearCart() {
        repository.clear();
        return "Carrito vaciado";
    }

    public List<Product> searchByName(String name) {
        return repository.findByName(name);
    }

    public int countProducts() {
        return repository.findAll().size();
    }
}