package com.charlie.example.web;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan("com.charlie.example.web.properties,com.charlie.example.services.service, com.charlie.example.services.dao,com.charlie.example.web.controller")
@EntityScan("com.charlie.example.model.entity")
public class MyApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyApplication.class, args);
    }
}            