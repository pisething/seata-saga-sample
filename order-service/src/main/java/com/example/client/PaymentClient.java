package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.config.FeignConfig;
import com.example.dto.OrderRequestDTO;

@FeignClient(name = "payment-service", url = "http://localhost:8083", configuration = FeignConfig.class) // change port if needed
public interface PaymentClient {

    @PostMapping("/payment/deduct")
    boolean deduct(@RequestBody OrderRequestDTO dto);
    
    @PostMapping("/payment/compensate")
    boolean compensate(@RequestBody OrderRequestDTO dto);
}
