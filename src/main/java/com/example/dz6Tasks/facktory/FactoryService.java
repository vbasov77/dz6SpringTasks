package com.example.dz6Tasks.facktory;

import com.example.dz6Tasks.observer.Subscriber;
import com.example.dz6Tasks.services.TaskService;
import org.springframework.stereotype.Service;

@Service
public class FactoryService {
    private final TaskService taskService;
    private final Subscriber subscriber;

    public FactoryService(TaskService taskService, Subscriber subscriber) {
        this.taskService = taskService;
        this.subscriber = subscriber;
    }

    public void addFactoryTask(String description, String status, String urgency) {
        if (urgency.equals("срочно")) {
            FactoryTask createUrgentTask = new CreateUrgentTask(taskService);
            UrgencyTask urgentTask = createUrgentTask.createTask();
            urgentTask.createTask(description, status);
        } else {
            FactoryTask createNotUrgentTask = new CreateNotUrgentTask(taskService);
            NotUrgentTask notUrgentTask = (NotUrgentTask) createNotUrgentTask.createTask();
            notUrgentTask.createTask(description, status);
        }

        subscriber.notifyObservers(description);
    }
}
