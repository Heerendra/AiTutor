package com.example.AiTutor.subject;

import com.example.AiTutor.model.ChatMessage;
import com.example.AiTutor.model.StudentQuestionRequest;

import java.util.List;

public interface SubjectPromptStrategy {
    String buildPrompt(StudentQuestionRequest request);

    String buildPromptWithMemory(
            StudentQuestionRequest request,
            List<ChatMessage> history
    );
}

