package com.example.demo.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname StategyClient
 * @Description TODO
 * @auth after
 * @since 2023/3/30 21:13
 */
public class StrategyClient {

    public static void main(String[] args) {
        List<BusinessHandler> handlers = new ArrayList<>();
        handlers.add(new OrderHandlerImpl());
        handlers.add(new ExportHandlerImpl());
        BusinessFactory businessFactory = new BusinessFactory(handlers);
        BusinessContext businessContext = new BusinessContext(businessFactory);
        businessContext.executeBusiness("order", "test", "is", "ok");
    }
}
