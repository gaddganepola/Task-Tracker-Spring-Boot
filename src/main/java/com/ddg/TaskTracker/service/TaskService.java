package com.ddg.TaskTracker.service;

import com.ddg.TaskTracker.model.Task;
import com.ddg.TaskTracker.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

    public Task updateTaskById(int id, Task task) {
        Task t1 = repo.findById(id).orElse(null);
        if (t1 == null) {
            return null;
        }
        t1.setTitle(task.getTitle());
        t1.setDescription(task.getDescription());
        t1.setDueDate(task.getDueDate());
        t1.setCompleted(task.isCompleted());
        return repo.save(t1);
    }

    public String loadData() {
        List<Task> tasks = new ArrayList<>(Arrays.asList(
            new Task(1, "Complete Spring Boot project", "Finish building the task tracker app with MySQL backend", LocalDate.of(2025, 8, 10), false),
            new Task(2, "Buy groceries", "Milk, eggs, bread, and vegetables", LocalDate.of(2025, 8, 3), true),
            new Task(3, "Read Spring Boot documentation", "Go through official docs to understand annotations and layers", LocalDate.of(2025, 8, 5), false),
            new Task(4, "Workout session", "Morning run and strength training", LocalDate.of(2025, 8, 2), true),
            new Task(5, "Submit assignment", "Submit database assignment before midnight", LocalDate.of(2025, 8, 4), false)
        ));
        repo.saveAll(tasks);
        if (repo.count() == 0) {
            return "Data not loaded";
        }
        return "Data loaded successfully";
    }

    public String markCompletedTask(int id) {
        Task t1 = repo.findById(id).orElse(null);
        if (t1 == null) {
            return "No such task found";
        }
        t1.setCompleted(true);
        repo.save(t1);
        return "Task marked as completed";
    }


    public List<Task> getExpiredTasks() {
        return repo.findByDueDateBefore(LocalDate.now());
    }

    public List<Task> getCompletedTasks() {
        return repo.findByCompleted(true);
    }

    public List<Task> getUncompletedTasks() {
        return repo.findByCompleted(false);
    }

    public List<Task> getTodayTasks() {
        return repo.findByDueDate(LocalDate.now());
    }

    public List<Task> getFutureTasks() {
        return repo.findByDueDateAfter(LocalDate.now());
    }

    public List<Task> searchByTitle(String title) {
        return repo.findByTitleContaining(title);
    }
}