package com.example.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.OrderRequestDTO;
import com.example.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
	private final PaymentService paymentService;

    @PostMapping("/deduct")
    public String deduct(@RequestBody OrderRequestDTO dto) {
        return paymentService.deduct(dto);
    }

    @PostMapping("/compensate")
    public String compensate(@RequestBody OrderRequestDTO dto) {
        return paymentService.compensate(dto);
    }
}
