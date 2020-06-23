package com.example.demo;

import com.example.demo.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by hongjian.chen on 2018/12/4.
 */

@FeignClient(value = "service-zuul2", configuration = FeignConfig.class, fallback = ZuulUserHystrix.class)
public interface ZuulUserService {

//    @GetMapping(value = "/uic/userList")
//    Map getAll();

//    @RequestMapping(value = "/uic/userList", method = RequestMethod.GET)
//    String getAll();

    @RequestMapping(value = "/ssm/project/queryProjects", method = RequestMethod.POST)
    String getAll(@RequestBody(required = false) String params);
}

