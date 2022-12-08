package com.java.project.meta.crm.nacosdiscovery;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author hy
 */
@EnableDiscoveryClient(autoRegister = false)
@Configuration
public class NacosDiscoveryConfiguration {
}
