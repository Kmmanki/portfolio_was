package com.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/*
    @spring boot
    @EnableAsync : 비동기 처리를 위한 어노테이션
 */
@SpringBootApplication(scanBasePackages = "com.portfolio")
@EnableAsync
public class PortfolioWasApplication {
    public static void main(String[] args) {

        SpringApplication.run(PortfolioWasApplication.class, args);
    }
}