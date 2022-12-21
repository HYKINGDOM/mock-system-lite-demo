package com.java.project.meta.crm.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/nacos")
public class NacosController {


    @Value("${banner.number}")
    private String bannerNumber;



    @GetMapping("/getBannerNumber")
    public String getBannerNumber(){

        return bannerNumber;
    }

}
