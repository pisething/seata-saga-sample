package com.example.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentserviceController {

    @PostMapping("/deduct")
    public String deduct(@RequestBody Map<String, Object> body) {
    	String orderId = (String) body.get("orderId");
        System.out.println("Payment deducted for order: " + orderId);
        return "Payment deducted";
    }

    @PostMapping("/compensate")
    public String compensate(@RequestBody Map<String, Object> body) {
    	String orderId = (String) body.get("orderId");
        System.out.println("Payment compensation triggered for order: " + orderId);
        return "Payment compensation successful";
    }
}
