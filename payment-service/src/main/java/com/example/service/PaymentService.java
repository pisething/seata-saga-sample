package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dto.OrderRequestDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {
	public boolean deduct(OrderRequestDTO dto) {

		log.info("Deduct Payment started : {}", dto);
		// In case amount less than zero, there is no deduct payment
		if(dto.getAmount() < 0) {
			throw new RuntimeException("Amount less than zero");
		}
		String orderId = dto.getOrderId();
		log.info("Payment deducted for order: {}", orderId);
		return true;
	}
	
	public boolean compensate(OrderRequestDTO dto) {

		log.info("Compensate Deduct Payment started : {}", dto);
		
		String orderId = dto.getOrderId();
		log.info("Payment compensation triggered for order: {}" , orderId);
        return true;
	}
}
