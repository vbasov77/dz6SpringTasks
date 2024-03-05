package com.example.dz6Tasks.facktory;

import com.example.dz6Tasks.services.TaskService;

public class CreateUrgentTask implements FactoryTask {

    private final TaskService taskService;

    public CreateUrgentTask(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public UrgencyTask createTask() {
        return new UrgentTask(taskService);
    }
}
