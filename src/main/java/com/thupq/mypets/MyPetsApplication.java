package com.thupq.mypets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.thupq.mypets.models.entity")
public class MyPetsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyPetsApplication.class, args);
    }

}
