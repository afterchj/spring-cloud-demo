package com.example.demo.strategy;

import org.springframework.stereotype.Component;

/**
 * @Classname BusinessHandler
 * @Description TODO
 * @auth after
 * @since 2023/3/30 20:57
 */

@Component
public class ExportHandlerImpl extends BusinessHandler {


    @Override
    public String getCode() {
        return "export";
    }

    @Override
    public void executeBusiness(String... var) {
        for (String s : var) {
            System.out.println("var=" + s);
            getCooperId(getCode(),s);
        }
    }


}
