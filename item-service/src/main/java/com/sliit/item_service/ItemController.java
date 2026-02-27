package com.sliit.item_service;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final List<String> items = new ArrayList<>(List.of("Book", "Laptop", "Phone"));

    @GetMapping
    public List<String> getItems() {
        return items;
    }

    @PostMapping
    public ResponseEntity<String> addItem(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("name is required");
        }
        items.add(name);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item added: " + name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getItem(@PathVariable int id) {
        if (id < 0 || id >= items.size()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(items.get(id));
    }
}
