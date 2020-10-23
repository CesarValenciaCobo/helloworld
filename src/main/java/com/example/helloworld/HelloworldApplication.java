package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloworldApplication extends SpringBootServletInitializer{

    public static void main(String[] args){
        SpringApplication.run(HelloworldApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HelloworldApplication.class);
    }

    @RequestMapping(value = "/")
    public String hello() {
        return "Hello World from Tomcat and docker and kubernetes...";
    }
}
