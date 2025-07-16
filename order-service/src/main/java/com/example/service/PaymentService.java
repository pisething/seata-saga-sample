package com.example.service;

import org.springframework.stereotype.Service;

import com.example.client.PaymentClient;
import com.example.dto.OrderRequestDTO;

import lombok.RequiredArgsConstructor;

@Service("paymentService")
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentClient paymentClient;

    public boolean deduct(OrderRequestDTO dto) {
    	return paymentClient.deduct(dto);
    }
    
    public boolean compensate(OrderRequestDTO dto) {
    	return paymentClient.compensate(dto);
    }
}
