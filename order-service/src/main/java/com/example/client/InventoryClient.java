package com.example.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "inventory-service", url = "http://localhost:8082") // change port if needed
public interface InventoryClient {

    @PostMapping("/inventory/deduct")
    String deduct(@RequestBody Map<String, Object> body);
    
    @PostMapping("/inventory/compensate")
    String compensate(@RequestBody Map<String, Object> body);
}
