package com.example.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryserviceController {

    @PostMapping("/deduct")
    public String deduct(@RequestBody Map<String, Object> body) {
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
