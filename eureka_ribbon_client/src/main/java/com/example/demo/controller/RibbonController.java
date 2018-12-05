package com.example.demo.controller;

import com.example.demo.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hongjian.chen on 2018/12/3.
 */

@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/hi")
    public String hi(@RequestParam(required = false,defaultValue = "ribbon") String name){
        return ribbonService.hi(name);
    }

    @GetMapping("/testRibbon")
    public String testRibbon(){
        ServiceInstance instance=loadBalancerClient.choose("eureka-client");
        return instance.getHost()+":"+instance.getPort();
    }
}
