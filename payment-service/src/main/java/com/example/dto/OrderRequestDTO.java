package com.example.dto;

import lombok.Data;

@Data
public class OrderRequestDTO {
    private String orderId;
    private String userId;
    private String productId;
    private int quantity;
    private double amount;
}
