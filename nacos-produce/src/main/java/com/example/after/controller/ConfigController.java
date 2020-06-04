package com.example.after.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @hjchen.chen
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${user.name}")
    private String userName;

    @Value("${user.age}")
    private int age;

    @RequestMapping(value = "/showConfig", method = RequestMethod.GET)
    public String show() {
        return "Hello Nacos Config! Hello " + userName + ",age" + age;
    }
}
