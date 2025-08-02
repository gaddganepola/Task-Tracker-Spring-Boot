package com.ddg.TaskTracker.repo;

import com.ddg.TaskTracker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Integer> {
}
