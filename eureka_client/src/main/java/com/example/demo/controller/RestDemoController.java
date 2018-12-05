package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hongjian.chen on 2018/12/3.
 */

@RestController
public class RestDemoController {
    @GetMapping("/testGet")
    public String testRest(){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject("https://www.baidu.com/",String.class);
    }
}
