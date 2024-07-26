package com.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "com.portfolio")
@EnableAsync
public class PortfolioWasApplication {
    public static void main(String[] args) {

        SpringApplication.run(PortfolioWasApplication.class, args);
    }
}