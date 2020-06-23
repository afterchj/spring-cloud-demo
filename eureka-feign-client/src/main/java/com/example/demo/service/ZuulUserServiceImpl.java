package com.example.demo.service;

import com.example.demo.ZuulUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by hongjian.chen on 2018/12/4.
 */

@Service
@Slf4j
public class ZuulUserServiceImpl implements ZuulUserService {

    @Autowired
    private ZuulUserService zuulUserService;

    @Override
    public String getAll(@RequestBody(required = false) String params) {
        return zuulUserService.getAll(params);
    }
}

