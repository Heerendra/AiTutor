package com.example.AiTutor.model;

public class AppGenerationResponse {

    private Long projectId;
    private String status;

    public AppGenerationResponse(Long projectId, String status) {
        this.projectId = projectId;
        this.status = status;
    }
}

