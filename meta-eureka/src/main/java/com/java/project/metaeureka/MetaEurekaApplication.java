package com.java.project.metaeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MetaEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetaEurekaApplication.class, args);
    }

}
