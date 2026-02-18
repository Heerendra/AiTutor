package com.example.AiTutor.generator;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileGenerationService {

    private static final String BASE_PATH = "./generated/";

    public void createBaseStructure(Long projectId) {
        new File(BASE_PATH + projectId + "/src/main/java").mkdirs();
    }

    public void writeCode(String content) {
        // Write files using AI output
    }
}
