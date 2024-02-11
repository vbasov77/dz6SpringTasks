package com.example.dz6Tasks.controllers;


import com.example.dz6Tasks.models.Task;
import com.example.dz6Tasks.services.DoService;
import com.example.dz6Tasks.services.PerformerService;
import com.example.dz6Tasks.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private PerformerService performerService;

    @Autowired
    private DoService doService;

    @GetMapping(value = "/")
    public String front(Model model) {
        List<Task> all = taskService.findAll();
        System.out.println(all);
        model.addAttribute("data", all);
        return "front";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        taskService.delete(id);
        return "redirect:/";
    }

    @GetMapping(value = "/view/{id}")
    public String view(Model model, @PathVariable("id") Long id) {
        Task task = taskService.findTaskById(id);
        List<String> performers = doService.findPerformersByDoId(id);
        model.addAttribute("task", task);
        model.addAttribute("performers", performers);
        return "/tasks/view";
    }

    @GetMapping(value = "/add-task")
    public String viewAddPage() {
        return "/tasks/add";
    }

    @PostMapping("/add-task")
    public String add(@RequestParam("description") String description, @RequestParam("status") String status) {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(status);
        taskService.create(task);

        return "redirect:/";
    }

    @GetMapping(value = "/edit-task/{id}")
    public String viewEditPage(@PathVariable Long id, Model model) {
        Task taskById = taskService.findTaskById(id);
        model.addAttribute("task", taskById);
        return "/tasks/edit";
    }

    @PostMapping(value = "/edit-task")
    public String edit(@RequestParam("description") String description,
                       @RequestParam("status") String status,
                       @RequestParam("id") Long id
    ) {
        taskService.updateTask(description, status, id);
        return "redirect:/";
    }


}
