package com.example.mybot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MyBotApplication {
    public static void main(String[] args){
        SpringApplication.run(MyBotApplication.class, args);
    }

}
