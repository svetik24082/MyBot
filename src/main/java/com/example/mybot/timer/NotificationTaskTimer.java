package com.example.mybot.timer;

import com.example.mybot.repository.NotificationTaskRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
@Component
public class NotificationTaskTimer {
    private final NotificationTaskRepository notificationTaskRepository;
    private final TelegramBot telegramBot;


    public NotificationTaskTimer(NotificationTaskRepository notificationTaskRepository,TelegramBot telegramBot) {
        this.notificationTaskRepository = notificationTaskRepository;
        this.telegramBot=telegramBot;
    }

    @Scheduled(fixedDelay = 1,timeUnit = TimeUnit.MINUTES) // вызов один раз в минуту
    public void task(){
        notificationTaskRepository.findAllByNotificationDateTime(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES)
        ).forEach(notificationTask -> {
            telegramBot.execute(
                    new SendMessage(notificationTask.getChatId(),"Вы просили напомнить о задаче" +
                            notificationTask.getMessage()));
            notificationTaskRepository.delete(notificationTask);

        });

    }
}
