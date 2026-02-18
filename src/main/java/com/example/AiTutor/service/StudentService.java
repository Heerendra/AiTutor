package com.example.AiTutor.service;

import com.example.AiTutor.model.Student;
import com.example.AiTutor.model.StudentRequest;
import com.example.AiTutor.model.StudentResponse;
import com.example.AiTutor.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentResponse create(StudentRequest request) {

        Student student = new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setPassword(request.getPassword()); // hashing later
        student.setGrade(request.getGrade());
        student.setCreatedAt(LocalDateTime.now());

        return new StudentResponse(repository.save(student));
    }

    public StudentResponse login(String email, String password) {

        Student student = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!student.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return new StudentResponse(student);
    }

    public List<StudentResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(StudentResponse::new)
                .toList();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

