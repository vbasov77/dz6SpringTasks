package com.example.dz6Tasks.facktory;

import com.example.dz6Tasks.models.Task;
import com.example.dz6Tasks.services.TaskService;

public class NotUrgentTask implements UrgencyTask{
    private final TaskService taskService;

    public NotUrgentTask(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void createTask(String description, String status) {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(status);
        task.setUrgency(0);

        taskService.save(task);
    }
}
