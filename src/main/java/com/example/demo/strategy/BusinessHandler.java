package com.example.demo.strategy;

/**
 * @Classname BusinessHandler
 * @Description TODO
 * @auth after
 * @since 2023/3/30 20:57
 */
public abstract class BusinessHandler {

    public abstract String getCode();

    public String getCooperId(String appType, String bizNo)  {
        System.out.println("threadName="+Thread.currentThread().getName()+",appType=" + appType + ",bizNo=" + bizNo);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.format("%s_%s_%s", getCode(), appType, bizNo);
    }

    public abstract void executeBusiness(String... var);
}
