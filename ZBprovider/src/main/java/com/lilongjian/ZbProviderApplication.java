package com.lilongjian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZbProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZbProviderApplication.class,args);
    }
}
