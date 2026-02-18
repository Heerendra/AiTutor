package com.example.AiTutor.service.ai;

import com.example.AiTutor.model.AppGenerationRequest;
import org.springframework.stereotype.Service;

@Service
public class PromptBuilderService {

    public String buildPrompt(AppGenerationRequest req) {
        return """
        Generate a %s application using %s.
        Features:
        %s
        Follow clean architecture.
        """.formatted(
                req.getAppType(),
                req.getTechStack(),
                String.join(",", req.getFeatures())
        );
    }
}
