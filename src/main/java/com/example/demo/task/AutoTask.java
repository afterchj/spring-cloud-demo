package com.example.demo.task;

import com.example.demo.strategy.BusinessContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Classname AutoTask
 * @Description TODO
 * @auth after
 * @since 2023/3/30 21:21
 */

@Component
public class AutoTask {

    private final BusinessContext businessContext;

    public AutoTask(BusinessContext businessContext) {
        this.businessContext = businessContext;
    }

    @PostConstruct
    public void stat() {
        System.out.println("threadName="+Thread.currentThread().getName()+"...");
        businessContext.executeBusiness("order", "test", "is", "ok");
    }
}
