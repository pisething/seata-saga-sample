package com.example.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/inventory")
@Slf4j
public class InventoryserviceController {

    @PostMapping("/deduct")
    public String deduct(@RequestBody Map<String, Object> body) {
    	
    	log.info("Request Body: {}", body);
    	String orderId = (String) body.get("orderId");
        System.out.println("Inventory deducted for order: " + orderId);
        return "Inventory deducted";
    }

    @PostMapping("/compensate")
    public String compensate(@RequestBody Map<String, Object> body) {
    	String orderId = (String) body.get("orderId");
        System.out.println("Inventory compensation triggered for order: " + orderId);
        return "Inventory compensation successful";
    }
}
