package com.example.AiTutor.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    private String appName;
    private String techStack;
    private String status; // CREATED, IN_PROGRESS, COMPLETED
    private LocalDateTime createdAt;
}

