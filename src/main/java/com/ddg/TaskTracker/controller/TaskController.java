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

//    Update Task By Id
    @PutMapping("task/{id}")
    public Task updateTaskById(@PathVariable int id, @RequestBody Task task) {
        return service.updateTaskById(id, task);
    }

//    Load Data
    @GetMapping("load")
    public String loadData() {
        return service.loadData();
    }

//    Mark Completed Task
    @PutMapping("task/complete/{id}")
    public String markCompletedTask(@PathVariable int id) {
        return service.markCompletedTask(id);
    }

//    Get Expired Tasks
    @GetMapping("tasks/expired")
    public List<Task> getExpiredTasks() {
        return service.getExpiredTasks();
    }

//    Get Completed Tasks
    @GetMapping("tasks/completed")
    public List<Task> getCompletedTasks() {
        return service.getCompletedTasks();
    }

//    Get Uncompleted Tasks
    @GetMapping("tasks/uncompleted")
    public List<Task> getUncompletedTasks() {
        return service.getUncompletedTasks();
    }

//    Get Today's Tasks
    @GetMapping("tasks/today")
    public List<Task> getTodayTasks() {
        return service.getTodayTasks();
    }

//    Get Future Tasks
    @GetMapping("tasks/future")
    public List<Task> getFutureTasks() {
        return service.getFutureTasks();
    }

//    Search By Title
    @GetMapping("tasks/search/{title}")
    public List<Task> searchByTitle(@PathVariable String title) {
        return service.searchByTitle(title);
    }



}
