package com.example.capas_cart.controller;


import com.example.capas_cart.model.Product;
import com.example.capas_cart.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    // ✅ Agregar
    @PostMapping
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price) {
        return service.addProduct(name, price);
    }

    // ✅ Listar
    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    // ✅ Total
    @GetMapping("/total")
    public double getTotal() {
        return service.calculateTotal();
    }

    // ✅ Eliminar
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.deleteProduct(id);
    }

    // ✅ Vaciar
    @DeleteMapping("/clear")
    public String clear() {
        return service.clearCart();
    }

    // ✅ Buscar
    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        return service.searchByName(name);
    }

    // ✅ Contar
    @GetMapping("/count")
    public int count() {
        return service.countProducts();
    }
}