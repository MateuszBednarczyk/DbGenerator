package com.matthew.databaseschemeinfocollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DatabaseSchemeInfoCollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseSchemeInfoCollectorApplication.class, args);
    }

}
