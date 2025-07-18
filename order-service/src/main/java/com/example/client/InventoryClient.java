package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.config.FeignConfig;
import com.example.dto.OrderRequestDTO;

@FeignClient(name = "inventory-service", url = "http://localhost:8082", configuration = FeignConfig.class) // change port if needed
public interface InventoryClient {

    @PostMapping("/inventory/deduct")
    boolean deduct(@RequestBody OrderRequestDTO dto);
    
    @PostMapping("/inventory/compensate")
    boolean compensate(@RequestBody OrderRequestDTO dto);
}
