package com.example.demo.strategy;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Classname BusinessContext
 * @Description TODO
 * @auth after
 * @since 2023/3/30 21:06
 */

@Component
public class BusinessContext {

    private BusinessFactory businessFactory;

    public BusinessContext(BusinessFactory businessFactory) {
        this.businessFactory = businessFactory;
    }

    @Async
    public void executeBusiness(String code, String... var) {
        businessFactory.generateHandler(code).executeBusiness(var);
    }
}
