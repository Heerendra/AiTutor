package com.example.AiTutor.model;

import com.example.AiTutor.subject.SubjectType;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentQuestionRequest {
    private Long studentId;
    private SubjectType subject;
    private String grade;     // 8, 10, 12, JEE, NEET
    private String topic;
    private String question;

    // getters & setters
}
