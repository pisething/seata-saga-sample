package com.example.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.seata.saga.rm.StateMachineEngineHolder;

@Configuration
public class SeataBeanConfig {

    @Bean
    StateMachineEngineHolder stateMachineEngineHolder() {
        return new StateMachineEngineHolder();
    }
}
