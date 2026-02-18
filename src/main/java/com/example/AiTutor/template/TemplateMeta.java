package com.example.AiTutor.template;

import lombok.Data;

import java.util.List;

@Data
public class TemplateMeta {

    private String templateId;
    private String techStack;
    private List<String> supportedFeatures;
}

