package com.example.demo.controller;

import com.example.demo.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hongjian.chen on 2018/12/4.
 */

@RestController
public class HiController {


    @Autowired
    private HiService hiService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "feign", required = false) String name) {
        return hiService.sayHi(name);
    }
}
