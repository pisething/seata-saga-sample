package com.example.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.client.PaymentClient;

import lombok.RequiredArgsConstructor;

@Service("paymentService")
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentClient paymentClient;

    public void deduct(Map<String, Object> context) {
    	paymentClient.deduct(context);
    }
    
    public void compensate(Map<String, Object> context) {
    	paymentClient.compensate(context);
    }
}
