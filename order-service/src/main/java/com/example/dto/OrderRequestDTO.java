package com.example.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -2503083726027001382L;
	private String orderId;
    private String userId;
    private String productId;
    private int quantity;
    private double amount;
}
