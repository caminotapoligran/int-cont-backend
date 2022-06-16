package com.example.intcontbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.intcontbackend.*")
public class IntContBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntContBackendApplication.class, args);
    }

}
