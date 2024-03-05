package com.example.dz6Tasks.services;


import com.example.dz6Tasks.annotations.LogNotFound;
import com.example.dz6Tasks.facktory.*;
import com.example.dz6Tasks.models.Task;
import com.example.dz6Tasks.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @LogNotFound
    public Task findTaskById(Long id) throws Exception {
        Task taskById = taskRepository.findTaskById(id);
        if (taskById == null) {
            throw new Exception("Обращение к несуществующему id");
        }
        return taskById;
    }

    public List<Task> findAllByStatus(String status) {
        return taskRepository.findAllByStatus(status);
    }

    public void create(Task task) {
        save(task);
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(String description, String status, Long id) {
        taskRepository.updateTask(description, status, id);
    }



    public void delete(Long id) {
        taskRepository.deleteTaskById(id);
    }
}
