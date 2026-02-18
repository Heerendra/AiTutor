package com.example.AiTutor.template;

import com.example.AiTutor.model.AppGenerationRequest;
import org.springframework.stereotype.Service;

@Service
public class TemplateService {

    public TemplateMeta selectTemplate(AppGenerationRequest req) {
        TemplateMeta meta = new TemplateMeta();
        meta.setTemplateId("springboot-crud");
        meta.setTechStack(req.getTechStack());
        return meta;
    }
}

