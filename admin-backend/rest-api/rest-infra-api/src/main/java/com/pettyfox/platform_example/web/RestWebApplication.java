package com.pettyfox.platform_example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan({"com.pettyfox.platform_example", "org.pettyfox.base.event"})
@EnableAsync
@EnableTransactionManagement
@RestController
@EnableScheduling
public class RestWebApplication {


    public static void main(String[] args) {
        SpringApplication.run(RestWebApplication.class, args);
    }

}
