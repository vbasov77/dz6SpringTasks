package com.example.dz6Tasks.observer;

import com.example.dz6Tasks.models.Task;

import java.util.List;

public interface Observer {
    void notifyObservers(String newTask);
}
