package com.example.AiTutor.controller;

import com.example.AiTutor.model.StudentAnswerResponse;
import com.example.AiTutor.model.StudentQuestionRequest;
import com.example.AiTutor.service.NotesService;
import com.example.AiTutor.service.SessionService;
import com.example.AiTutor.service.TeachingAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")
public class TeachingController {

    private final TeachingAIService service;

    public TeachingController(TeachingAIService service) {
        this.service = service;
    }

    @PostMapping("/ask")
    public StudentAnswerResponse ask(
            @RequestBody StudentQuestionRequest request) {

        return service.teach(request);
    }

}

