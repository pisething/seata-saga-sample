package com.example.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.client.InventoryClient;

import lombok.RequiredArgsConstructor;

@Service("inventoryService")
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryClient inventoryClient;

    public void deduct(Map<String, Object> context) {
        inventoryClient.deduct(context);
    }
    
    public void compensate(Map<String, Object> context) {
        inventoryClient.compensate(context);
    }
}
