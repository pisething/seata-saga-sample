package com.example.service;

import org.springframework.stereotype.Service;

import com.example.dto.OrderRequestDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InventoryService {
	
	public boolean deduct(OrderRequestDTO dto) {

		log.info("Deduct Inventory started : {}", dto);
		// In case quantity less than 1, there is no deduct inventory
		if(dto.getQuantity() < 1) {
			throw new RuntimeException("Quantity less than one");
		}
		String orderId = dto.getOrderId();
		log.info("Inventory deducted for order: {}", orderId);
		return true;
	}
	
	public boolean compensate(OrderRequestDTO dto) {

		log.info("Compensate Deduct Inventory started : {}", dto);
		
		String orderId = dto.getOrderId();
		log.info("Inventory compensation triggered for order: {}" , orderId);
        return true;
	}
}
