package com.example.AiTutor.model;

import com.example.AiTutor.subject.SubjectType;
import lombok.Data;


@Data
public class StudentAnswerResponse {

    private SubjectType subject;
    private String answer;

    public StudentAnswerResponse(SubjectType subject, String answer) {
        this.subject = subject;
        this.answer = answer;
    }
}
