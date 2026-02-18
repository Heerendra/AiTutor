package com.example.AiTutor.controller;

import com.example.AiTutor.model.AppGenerationRequest;
import com.example.AiTutor.model.AppGenerationResponse;
import com.example.AiTutor.model.ProjectEntity;
import com.example.AiTutor.service.AppGenerationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/app")
public class AppGenerationController {

    private final AppGenerationService service;

    public AppGenerationController(AppGenerationService service) {
        this.service = service;
    }

    @PostMapping("/generate")
    public AppGenerationResponse generate(@RequestBody AppGenerationRequest request) {
        return service.generateApp(request);
    }

    @GetMapping("/status/{projectId}")
    public ProjectEntity status(@PathVariable Long projectId) {
        return service.getStatus(projectId);
    }
}
