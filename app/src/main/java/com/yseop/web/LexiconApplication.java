package com.yseop.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application of Browser
 */
@SpringBootApplication(scanBasePackages = { "com.yseop.web" })
public class LexiconApplication {

    public static void main(String[] args) {
        SpringApplication.run(LexiconApplication.class, args);
    }
}