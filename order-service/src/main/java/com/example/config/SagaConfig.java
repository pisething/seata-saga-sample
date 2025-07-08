package com.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.seata.saga.engine.StateMachineConfig;
import io.seata.saga.engine.StateMachineEngine;
import io.seata.saga.engine.config.DbStateMachineConfig;
import io.seata.saga.engine.impl.ProcessCtrlStateMachineEngine;

@Configuration
public class SagaConfig {

    @Bean
    StateMachineConfig sagaStateMachineConfig(DataSource dataSource) {
        DbStateMachineConfig cfg = new DbStateMachineConfig();
        cfg.setDataSource(dataSource);
        cfg.setResources(new String[]{"statelang/*.json"});
        cfg.setApplicationId("order-service");
        cfg.setTxServiceGroup("order-saga-group");
        cfg.setEnableAsync(false);
        return cfg;
    }

    @Bean
    StateMachineEngine stateMachineEngine(StateMachineConfig cfg) {
        ProcessCtrlStateMachineEngine engine = new ProcessCtrlStateMachineEngine();
        engine.setStateMachineConfig(cfg);
        return engine;
    }
}
