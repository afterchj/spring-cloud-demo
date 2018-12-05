package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hongjian.chen on 2018/12/5.
 */

@RestController
@RefreshScope
//@PropertySource(value = "classpath:application.yml",ignoreResourceNotFound = true)
public class TestController {

    @Value("${my.foo}")
    private String foo;

    @RequestMapping("/foo")
    public String test() {
        return foo;
    }
}
