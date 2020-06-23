package com.example.demo.controller;

import com.example.demo.Entity.SearchDict;
import com.example.demo.ZuulUserService;
import com.example.demo.service.HiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

/**
 * Created by hongjian.chen on 2018/12/4.
 */

@RestController
@Slf4j
public class HomeController {


    @Autowired
    private ZuulUserService zuulUserService;

    @RequestMapping(value = "/getProjects",method = RequestMethod.POST)
    public String getProjects(@RequestBody(required = false)  String params) {
        log.warn("params {}",params);
        return zuulUserService.getAll(params);
    }
}
