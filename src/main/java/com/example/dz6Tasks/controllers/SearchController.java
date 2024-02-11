package com.example.dz6Tasks.controllers;

import com.example.dz6Tasks.models.Task;
import com.example.dz6Tasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/get-status")
    public String getByStatus(@RequestParam String status, Model model) {
        List<Task> allByStatus = taskService.findAllByStatus(status);
        model.addAttribute("data", allByStatus);

        return "front";
    }
}
