package com.example.after;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by after on 2020/5/29.
 */

@RestController
public class ConfigController {

    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping(value = "/test")
    public String getProperties() {
        return "result:" + applicationName + "," + serverPort;
    }
}
