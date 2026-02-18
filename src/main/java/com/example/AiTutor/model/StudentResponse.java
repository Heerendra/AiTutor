package com.example.AiTutor.model;

import lombok.Data;

@Data
public class StudentResponse {

    private Long id;
    private String name;
    private String email;
    private String grade;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.grade = student.getGrade();
    }
}

