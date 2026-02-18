package com.example.AiTutor.controller;

import com.example.AiTutor.model.StudentRequest;
import com.example.AiTutor.model.StudentResponse;
import com.example.AiTutor.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public StudentResponse register(@RequestBody StudentRequest request) {
        return service.create(request);
    }

    @PostMapping("/login")
    public StudentResponse login(
            @RequestParam String email,
            @RequestParam String password) {

        return service.login(email, password);
    }

    @GetMapping
    public List<StudentResponse> all() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

