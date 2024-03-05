package com.example.dz6Tasks.facktory;

import com.example.dz6Tasks.models.Task;
import com.example.dz6Tasks.services.TaskService;

public class UrgentTask implements UrgencyTask {

    private final TaskService taskService;

    public UrgentTask(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public void createTask(String description, String status) {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(status);
        task.setUrgency(1);

        taskService.save(task);
    }
}
