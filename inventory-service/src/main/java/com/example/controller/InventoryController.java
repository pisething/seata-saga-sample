package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.OrderRequestDTO;
import com.example.service.InventoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {
	private final InventoryService inventoryService;

    @PostMapping("/deduct")
    public boolean deduct(@RequestBody OrderRequestDTO dto) {
        return inventoryService.deduct(dto);
    }

    @PostMapping("/compensate")
    public boolean compensate(@RequestBody OrderRequestDTO dto) {
        return inventoryService.compensate(dto);
    }
}
