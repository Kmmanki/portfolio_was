package com.portfoio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.portfoio")
public class PortfolioWasApplication {
    public static void main(String[] args) {

        SpringApplication.run(PortfolioWasApplication.class, args);
    }
}