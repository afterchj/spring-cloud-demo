package com.example.demo.strategy;

import org.springframework.stereotype.Component;

/**
 * @Classname BusinessHandler
 * @Description TODO
 * @auth after
 * @since 2023/3/30 20:57
 */

@Component
public class OrderHandlerImpl extends BusinessHandler {


    @Override
    public String getCode() {
        return "order";
    }

    @Override
    public void executeBusiness(String... var) {
        for (String s : var) {
            System.out.println("threadName=" + Thread.currentThread().getName() + ",var=" + s);
            String cooperId = getCooperId(getCode(), s);
            System.out.println("cooperId="+cooperId);
        }
    }
}
