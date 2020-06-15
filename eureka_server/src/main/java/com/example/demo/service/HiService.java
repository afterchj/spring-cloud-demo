package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hongjian.chen on 2018/12/4.
 */

@Service
public class HiService {

    public String sayHi(String name) {

        String str = String.format("test_%s", name);
        return str;
    }
}
