package com.example.capas_cart.controller;

import com.example.capas_cart.model.Product;
import com.example.capas_cart.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping
    public String add(@RequestParam String name, @RequestParam double price) {
        return service.add(name, price);
    }

    @GetMapping
    public List<Product> list() {
        return service.list();
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String name,
                         @RequestParam double price) {
        return service.update(id, name, price);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @DeleteMapping("/clear")
    public void clear() {
        service.clear();
    }

    @GetMapping("/total")
    public double total() {
        return service.total();
    }

    @PostMapping("/checkout")
    public String checkout() {
        return service.checkout();
    }
}