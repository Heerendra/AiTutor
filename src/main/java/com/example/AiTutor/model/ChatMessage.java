package com.example.AiTutor.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sessionId;

    @Column(length = 5000)
    private String question;

    @Column(length = 5000)
    private String answer;

    private LocalDateTime timestamp;

    public ChatMessage(Long sessionId, String question, String answer, LocalDateTime timestamp) {
        this.sessionId = sessionId;
        this.question = question;
        this.answer = answer;
        this.timestamp = timestamp;
    }
}

