package com.example.after.util;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.NamingEvent;

import java.util.EventListener;
import java.util.Properties;

/**
 * Created by after on 2020/5/30.
 */
public class NamingExample {
    public static void main(String[] args) {

        try {

            Properties properties = new Properties();
            properties.setProperty("serverAddr", "119.3.12.87:8848");
            properties.setProperty("namespace", "springboot-nacos");

            NamingService naming = NamingFactory.createNamingService(properties);

            naming.registerInstance("nacos-demo", "119.3.12.87", 8848, "TEST1");

            System.out.println(naming.getAllInstances("nacos-demo"));

            System.out.println(naming.getAllInstances("nacos-demo"));

            naming.subscribe("nacos-demo", (event) -> {
                System.out.println(((NamingEvent) event).getServiceName());
                System.out.println(((NamingEvent) event).getInstances());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
