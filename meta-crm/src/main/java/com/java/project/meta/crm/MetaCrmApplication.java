package com.java.project.meta.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class MetaCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetaCrmApplication.class, args);
    }

}
