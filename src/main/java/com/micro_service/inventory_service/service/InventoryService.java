package com.micro_service.inventory_service.service;

import com.micro_service.inventory_service.repository.InventoryRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public boolean isInStock(String productCode, int requiredQuantity) {
        int available = inventoryRepository.getQuantityByProductCode(productCode);
        return available >= requiredQuantity;
    }
}
