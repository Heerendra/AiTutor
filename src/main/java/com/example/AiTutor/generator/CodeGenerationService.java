package com.example.AiTutor.generator;

import com.example.AiTutor.model.ProjectEntity;
import com.example.AiTutor.template.TemplateMeta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeGenerationService {

    private final FileGenerationService fileService;

    public void generate(ProjectEntity project,
                         TemplateMeta template,
                         String aiOutput) {

        fileService.createBaseStructure(project.getProjectId());
        fileService.writeCode(aiOutput);
    }
}

