package com.example.eurekamonitorclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class EurekaMonitorClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMonitorClientApplication.class, args);
    }

}
