package com.example.service;

import org.springframework.stereotype.Service;

import com.example.client.PaymentClient;
import com.example.dto.OrderRequestDTO;

import lombok.RequiredArgsConstructor;

@Service("paymentService")
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentClient paymentClient;

    public void deduct(OrderRequestDTO dto) {
    	paymentClient.deduct(dto);
    }
    
    public void compensate(OrderRequestDTO dto) {
    	paymentClient.compensate(dto);
    }
}
