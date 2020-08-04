package com.example.demo.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author hongjian.chen
 * @date 2020/7/31 13:39
 */
@Service
@Slf4j
public class RedisService {

    public void consumeMsg(String msg) {
        System.out.println("---------------分割线----------------");
        log.warn("msg {}", msg);
        Map<String, Object> receive = JSON.parseObject(msg);
        for (String key : receive.keySet()) {
            System.out.println("key=" + key + " and value=" + receive.get(key));
        }
        log.warn("name=" + receive.get("name"));
    }

    public void receiverMessage(String msg) {
        System.out.println("---------------分割线----------------");
        log.warn("msg {}", msg);
        Map receive = JSON.parseObject(msg);
        log.warn("name=" + receive.get("name"));
    }
}