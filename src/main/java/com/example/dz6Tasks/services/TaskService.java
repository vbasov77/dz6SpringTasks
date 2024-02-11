package com.example.dz6Tasks.services;


import com.example.dz6Tasks.models.Task;
import com.example.dz6Tasks.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public Task findTaskById(Long id) {
        return taskRepository.findTaskById(id);
    }

    public List<Task> findAllByStatus(String status) {
        return taskRepository.findAllByStatus(status);
    }

    public void create(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(String description, String status, Long id) {
        taskRepository.updateTask(description, status, id);
    }
}
