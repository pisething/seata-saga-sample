package com.example.config;

import org.springframework.context.annotation.Configuration;

import io.seata.saga.engine.StateMachineEngine;
import io.seata.saga.rm.StateMachineEngineHolder;
import jakarta.annotation.PostConstruct;

@Configuration
public class StateMachineEngineHolderConfig {

    private final StateMachineEngine stateMachineEngine;
    private final StateMachineEngineHolder stateMachineEngineHolder;

    public StateMachineEngineHolderConfig(StateMachineEngine stateMachineEngine,
                                          StateMachineEngineHolder stateMachineEngineHolder) {
        this.stateMachineEngine = stateMachineEngine;
        this.stateMachineEngineHolder = stateMachineEngineHolder;
    }

    @PostConstruct
    public void init() {
        stateMachineEngineHolder.setStateMachineEngine(stateMachineEngine);
    }
}
