package com.portfolio.portfolio_was.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SwaggerConfig
 */
@Configuration
public class SwaggerConfig {

  
  @Bean
  public GroupedOpenApi api() {
    String[] paths = {"/**"};
    // String[] pakcagesToScan = {"com.portfolio.portfolio_was"};
    return GroupedOpenApi.builder().group("springdoc-openapi")
    .pathsToMatch(paths)
    // .packagesToScan(pakcagesToScan)
    .build();
  }
}