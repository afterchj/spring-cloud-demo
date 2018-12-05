package com.example.demo.service;

import com.example.demo.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hongjian.chen on 2018/12/4.
 */

@Service
public class HiService {

    @Autowired
    private EurekaClientFeign eurekaClientFeign;

    public String sayHi(String name){
        return eurekaClientFeign.sayHiFromEurekaClient(name);
    }
}
