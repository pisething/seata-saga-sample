package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.OrderRequestDTO;

import io.seata.saga.engine.StateMachineEngine;
import io.seata.saga.statelang.domain.StateMachineInstance;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderSagaController {

    private final StateMachineEngine stateMachineEngine;

    @PostMapping("/create")
    public String createOrder(OrderRequestDTO dto) {

    	Map<String, Object> args = new HashMap<>();

    	args.put("context", dto);

        StateMachineInstance instance = stateMachineEngine.start("order_saga", null, args);
        return "Saga status: " + instance.getStatus();
    }
}
