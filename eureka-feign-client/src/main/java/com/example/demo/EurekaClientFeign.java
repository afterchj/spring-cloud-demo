package com.example.demo;

import com.example.demo.config.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by hongjian.chen on 2018/12/4.
 */

@FeignClient(value = "eureka-client",configuration = FeignConfig.class,fallback = HiHystrix.class)
public interface EurekaClientFeign {

    @GetMapping(value = "/hi")
    String sayHiFromEurekaClient(@RequestParam(value = "name",defaultValue = "feign") String name);
}

