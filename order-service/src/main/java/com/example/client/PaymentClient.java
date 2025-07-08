package com.example.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service", url = "http://localhost:8083") // change port if needed
public interface PaymentClient {

    @PostMapping("/payment/deduct")
    String deduct(@RequestBody Map<String, Object> body);
    
    @PostMapping("/payment/compensate")
    String compensate(@RequestBody Map<String, Object> body);
}
