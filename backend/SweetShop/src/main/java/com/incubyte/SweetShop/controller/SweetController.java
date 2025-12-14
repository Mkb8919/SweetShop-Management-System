package com.incubyte.SweetShop.controller;


import com.incubyte.SweetShop.entity.Sweet;
import com.incubyte.SweetShop.service.SweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sweets")
public class SweetController {

    @Autowired
    private SweetService sweetService;

    @PostMapping
    public Sweet addSweet(@RequestBody Sweet sweet) {
        return sweetService.addSweet(sweet);
    }

    @GetMapping
    public List<Sweet> getAllSweets() {
        return sweetService.getAllSweets();
    }

    @GetMapping("/{id}")
    public Sweet getSweetById(@PathVariable Long id) {
        return sweetService.getSweetById(id).orElseThrow(() -> new RuntimeException("Sweet not found"));
    }

    @PutMapping("/{id}")
    public Sweet updateSweet(@PathVariable Long id, @RequestBody Sweet sweet) {
        return sweetService.updateSweet(id, sweet);
    }

    @DeleteMapping("/{id}")
    public String deleteSweet(@PathVariable Long id) {
        sweetService.deleteSweet(id);
        return "Sweet deleted successfully";
    }

    @PostMapping("/{id}/purchase")
    public Sweet purchaseSweet(@PathVariable Long id, @RequestParam int quantity) {
        return sweetService.purchaseSweet(id, quantity);
    }

    @PostMapping("/{id}/restock")
    public Sweet restockSweet(@PathVariable Long id, @RequestParam int quantity) {
        return sweetService.restockSweet(id, quantity);
    }






}
