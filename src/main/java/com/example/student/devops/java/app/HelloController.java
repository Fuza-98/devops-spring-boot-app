package com.example.student.devops.java.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello DevOps from Java Spring Boot!";
    }

    @GetMapping("/health")
    public String health() {
        return "Application is running successfully.";
    }
}