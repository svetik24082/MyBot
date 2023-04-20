package com.example.mybot.config;

import com.pengrad.telegrambot.TelegramBot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelegramBotConfiguration {

    @Bean
    public TelegramBot telegramBot(@Value("6138957660:AAGvwOzsGXLIMTYejQPf32tu9vstQzc7ZIo") String token) {
        return new TelegramBot(token);
    }
}



