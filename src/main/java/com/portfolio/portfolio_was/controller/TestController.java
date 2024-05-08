package com.portfolio.portfolio_was.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RequestMapping("/test")
@RestController
public class TestController {
 
  @GetMapping("/api1")
  @Tag(name = "test api")
  @Operation(summary = "test")
  public String test22() {
    return "test";
  }
}
