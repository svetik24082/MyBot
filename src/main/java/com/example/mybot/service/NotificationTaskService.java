package com.example.mybot.service;

import com.example.mybot.entity.NotificationTask;
import com.example.mybot.repository.NotificationTaskRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationTaskService {
    private final NotificationTaskRepository notificationTaskRepository;

    public NotificationTaskService(NotificationTaskRepository notificationTaskRepository) {
        this.notificationTaskRepository = notificationTaskRepository;

    }
    public  void  save(NotificationTask notificationTask){
        notificationTaskRepository.save(notificationTask);
    }
}
