package com.example.dz6Tasks.facktory;

import com.example.dz6Tasks.services.TaskService;

public class CreateNotUrgentTask implements FactoryTask {
    private final TaskService taskService;

    public CreateNotUrgentTask(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public UrgencyTask createTask() {
        return new UrgentTask(taskService);
    }
}
