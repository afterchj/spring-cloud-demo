package com.example.after;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@SpringBootApplication
@NacosPropertySource(dataId = "springcloud-nacos-hello", autoRefreshed = true)
@RestController
public class NacosProvideApplication {


    private static Logger logger = LoggerFactory.getLogger(NacosProvideApplication.class);

    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @NacosValue(value = "${user.name:hjchen}", autoRefreshed = true)
    private String name;

    @NacosInjected
    private NamingService namingService;

//    @Bean
//    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//        configurer.setIgnoreUnresolvablePlaceholders(true);
//        return configurer;
//    }

    @PostConstruct
    public void registerInstance() {
        logger.warn("serviceName {} port {}", applicationName, serverPort);
        try {
            namingService.registerInstance(applicationName, "119.3.12.87", serverPort);
        } catch (NacosException e) {
            logger.error(e.getMessage());
        }
    }

    @RequestMapping(value = "/getInstance", method = GET)
    public List<Instance> getInstance(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }


    @GetMapping("/show")
    public String get() {
        return name;
    }

    public static void main(String[] args) {
        SpringApplication.run(NacosProvideApplication.class, args);
    }
}
