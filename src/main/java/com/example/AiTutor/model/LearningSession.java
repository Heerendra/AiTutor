package com.example.AiTutor.model;

import com.example.AiTutor.subject.SubjectType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class LearningSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Enumerated(EnumType.STRING)
    private SubjectType subject;

    private boolean active;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
