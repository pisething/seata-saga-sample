package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.seata.saga.engine.StateMachineEngine;
import io.seata.saga.statelang.domain.StateMachineInstance;

@RestController
@RequestMapping("/api/order")
public class OrderSagaController {

    private final StateMachineEngine stateMachineEngine;

    public OrderSagaController(StateMachineEngine stateMachineEngine) {
        this.stateMachineEngine = stateMachineEngine;
    }

    @PostMapping("/create")
    public String createOrder(@RequestParam String orderId,
                              @RequestParam String userId,
                              @RequestParam String productId,
                              @RequestParam int quantity,
                              @RequestParam double amount) {

    	Map<String, Object> args = new HashMap<>();
    	args.put("orderId", orderId);
    	args.put("userId", userId);
    	args.put("productId", productId);
    	args.put("quantity", quantity);
    	args.put("amount", amount);


        StateMachineInstance instance = stateMachineEngine.start("order_saga", null, args);
        return "Saga status: " + instance.getStatus();
    }
}
