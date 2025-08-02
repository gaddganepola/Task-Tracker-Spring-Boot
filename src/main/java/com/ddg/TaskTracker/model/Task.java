package com.ddg.TaskTracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class Task {

    @Id
    private int id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

}
