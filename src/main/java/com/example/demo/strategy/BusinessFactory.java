package com.example.demo.strategy;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname BusinessFactory
 * @Description TODO
 * @auth after
 * @since 2023/3/30 21:07
 */

@Component
public class BusinessFactory {

    private final Map<String, BusinessHandler> handlerMap = new HashMap<>();

    public BusinessFactory(List<BusinessHandler> businessHandlers) {
        businessHandlers.forEach(handler -> {
            handlerMap.put(handler.getCode(), handler);
        });
    }

    public BusinessHandler generateHandler(String code) {
        return handlerMap.get(code);
    }
}
