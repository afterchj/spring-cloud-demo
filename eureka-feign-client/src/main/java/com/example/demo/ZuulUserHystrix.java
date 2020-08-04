package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.entitys.dd.ResultDict;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ZuulUserHystrix
 * @Description TODO
 * @Date 2020/6/17 11:01
 * @Created by hjchen
 */

@Component
public class ZuulUserHystrix implements ZuulUserService {

    @Override
    public String getAll(@RequestBody(required = false) String params) {
        Map result = new HashMap();
        result.put("code", ResultDict.SYSTEM_ERROR.getCode());
        result.put("msg", ResultDict.SYSTEM_ERROR.getValue());
        return JSON.toJSONString(result);
    }
}
