package com.ddg.TaskTracker.repo;

import com.ddg.TaskTracker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Integer> {
    List<Task> findByDueDateBefore(LocalDate now);

    List<Task> findByCompleted(boolean b);

    List<Task> findByDueDate(LocalDate now);

    List<Task> findByDueDateAfter(LocalDate now);

    List<Task> findByTitleContaining(String title);
}
