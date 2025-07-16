package com.example.service;

import org.springframework.stereotype.Service;

import com.example.client.InventoryClient;
import com.example.dto.OrderRequestDTO;

import lombok.RequiredArgsConstructor;

@Service("inventoryService")
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryClient inventoryClient;

    public boolean deduct(OrderRequestDTO dto) {
        return inventoryClient.deduct(dto);
    }
    
    public boolean compensate(OrderRequestDTO dto) {
        return inventoryClient.compensate(dto);
    }
}
