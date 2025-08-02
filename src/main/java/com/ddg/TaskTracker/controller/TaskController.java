package com.ddg.TaskTracker.controller;

import com.ddg.TaskTracker.model.Task;
import com.ddg.TaskTracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    Get Task By Id
    @GetMapping("task/{id}")
    public Task getTaskById(@PathVariable int id) {
        return service.getTaskById(id);
    }

//    Delete Task By Id
    @DeleteMapping("task/{id}")
    public String deleteTaskById(@PathVariable int id) {
        return service.deleteTaskById(id);
    }



}
