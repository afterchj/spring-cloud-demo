package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by hongjian.chen on 2018/12/4.
 */

@Component
public class HiHystrix implements EurekaClientFeign {
    @Override
    public String sayHiFromEurekaClient(@RequestParam(value = "name",defaultValue = "hystrix") String name) {
        return "Hi," + name + ",sorry,error";
    }
}
