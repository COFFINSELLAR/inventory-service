package com.micro_service.inventory_service.controller;

import com.micro_service.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/check")
    public ResponseEntity<Boolean> isProductInStock(
            @RequestParam String productCode,
            @RequestParam int quantity) {
        boolean inStock = inventoryService.isInStock(productCode, quantity);
        return ResponseEntity.ok(inStock);
    }
}
