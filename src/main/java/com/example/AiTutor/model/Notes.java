package com.example.AiTutor.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sessionId;

    @Column(length = 10000)
    private String content;

    private String pdfPath;
}

