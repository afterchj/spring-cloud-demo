package com.example.demo.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by hongjian.chen on 2018/12/4.
 */

@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetry() {
        return new Retryer.Default(100, SECONDS.toMillis(1), 5);
    }
}

