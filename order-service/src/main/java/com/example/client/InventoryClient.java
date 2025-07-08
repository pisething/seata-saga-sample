package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.OrderRequestDTO;

@FeignClient(name = "inventory-service", url = "http://localhost:8082") // change port if needed
public interface InventoryClient {

    @PostMapping("/inventory/deduct")
    String deduct(@RequestBody OrderRequestDTO dto);
    
    @PostMapping("/inventory/compensate")
    String compensate(@RequestBody OrderRequestDTO dto);
}
