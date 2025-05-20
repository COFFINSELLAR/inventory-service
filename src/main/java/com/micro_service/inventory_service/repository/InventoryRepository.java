package com.micro_service.inventory_service.repository;

import com.micro_service.inventory_service.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InventoryRepository extends JpaRepository<InventoryRepository, String> {

    InventoryEntity findByProductCode(String productCode);

    @Query("SELECT i.quantity FROM InventoryEntity i WHERE i.productCode = :productCode")
    int getQuantityByProductCode(String productCode);
}
