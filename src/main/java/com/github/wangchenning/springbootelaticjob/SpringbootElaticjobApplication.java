package com.github.wangchenning.springbootelaticjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringbootElaticjobApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootElaticjobApplication.class, args);
    }

}
