package com.example.beproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BeProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeProductApplication.class, args);
    }

}
