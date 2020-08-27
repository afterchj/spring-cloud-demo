package com.example.after.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @hjchen.chen
 */
@RestController
@RequestMapping("/echo")
public class EchoController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map test(@RequestBody(required = false) Map params) {
        logger.warn("params{}", params);
        Map result = new HashMap();
        result.put("code", "000");
        result.put("nsg", "成功");
        return result;
    }
}
