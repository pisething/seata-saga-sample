package com.example.service;

import org.springframework.stereotype.Service;

import com.example.client.InventoryClient;
import com.example.dto.OrderRequestDTO;

import lombok.RequiredArgsConstructor;

@Service("inventoryService")
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryClient inventoryClient;

    public void deduct(OrderRequestDTO dto) {
        inventoryClient.deduct(dto);
    }
    
    public void compensate(OrderRequestDTO dto) {
        inventoryClient.compensate(dto);
    }
}
