package com.ddg.TaskTracker.controller;

import com.ddg.TaskTracker.model.Task;
import com.ddg.TaskTracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService service;

//    Create Task
    @PostMapping("task")
    public Task createTask(@RequestBody Task task) {
        return service.createTask(task);
    }

//    Get All Tasks
    @GetMapping("tasks")
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

}
