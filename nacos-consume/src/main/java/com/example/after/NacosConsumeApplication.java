package com.example.after;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class NacosConsumeApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumeApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/test/{str}")
    public String test(@PathVariable String str) {
        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-test");
        String url = serviceInstance.getUri() + "/echo/" + str;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "Invoke : " + url + ", return : " + result;
    }
}
