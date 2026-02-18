package com.example.AiTutor.model;

import lombok.Data;

import java.util.List;

@Data
public class AppGenerationRequest {

    private String appName;
    private String appType;    // WEB / API
    private String techStack;  // SPRING_BOOT
    private List<String> features;
}

