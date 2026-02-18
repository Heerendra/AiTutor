package com.example.AiTutor.service;

import com.example.AiTutor.generator.CodeGenerationService;
import com.example.AiTutor.model.AppGenerationRequest;
import com.example.AiTutor.model.AppGenerationResponse;
import com.example.AiTutor.model.ProjectEntity;
import com.example.AiTutor.service.ai.AIClientService;
import com.example.AiTutor.service.ai.PromptBuilderService;
import com.example.AiTutor.template.TemplateMeta;
import com.example.AiTutor.template.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppGenerationService {

    private final PromptBuilderService promptService;
    private final AIClientService aiService;
    private final TemplateService templateService;
    private final CodeGenerationService codeService;
    private final ProjectService projectService;

    public AppGenerationResponse generateApp(AppGenerationRequest request) {

        ProjectEntity project = projectService.create(request);

        String prompt = promptService.buildPrompt(request);
        String aiOutput = aiService.generate(prompt);

        TemplateMeta template = templateService.selectTemplate(request);
        codeService.generate(project, template, aiOutput);

        projectService.complete(project.getProjectId());

        return new AppGenerationResponse(project.getProjectId(), "COMPLETED");
    }

    public ProjectEntity getStatus(Long projectId) {
        return projectService.get(projectId);
    }
}

