package com.DrugSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TBApplication {
    public static void main(String[] args) {
        SpringApplication.run(TBApplication.class,args);
    }
}
