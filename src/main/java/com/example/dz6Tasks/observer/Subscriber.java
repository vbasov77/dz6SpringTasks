package com.example.dz6Tasks.observer;

import com.example.dz6Tasks.models.Notification;
import com.example.dz6Tasks.models.User;
import com.example.dz6Tasks.repositories.NotificationRepository;
import com.example.dz6Tasks.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Subscriber implements Observer {

    private final UserRepository userRepository;

    private final NotificationRepository notificationRepository;

    public Subscriber(UserRepository userRepository, NotificationRepository notificationRepository) {
        this.userRepository = userRepository;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void notifyObservers(String newTask) {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            Notification notification = new Notification();
            notification.setUserId(user.getId());
            notification.setText("Создано новое задание " + newTask);

            notificationRepository.save(notification);
        }
    }
}
