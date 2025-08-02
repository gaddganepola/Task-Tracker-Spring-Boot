package com.ddg.TaskTracker.service;

import com.ddg.TaskTracker.model.Task;
import com.ddg.TaskTracker.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepo repo;

    public Task createTask(Task task) {
        return repo.save(task);
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    public Task getTaskById(int id) {
        return repo.findById(id).orElse(null);
    }

    public String deleteTaskById(int id) {
        Task t1 = repo.findById(id).orElse(null);
        if (t1 == null) {
            return "No such task found";
        }else {
            repo.deleteById(id);
            t1 = repo.findById(id).orElse(null);
            return "Task deleted successfully";
        }
    }
}