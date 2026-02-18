package com.example.AiTutor.subject;

import com.example.AiTutor.model.ChatMessage;
import com.example.AiTutor.model.StudentQuestionRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChemistryTeacher implements SubjectPromptStrategy {
    @Override
    public String buildPrompt(StudentQuestionRequest req) {
        return buildPromptWithMemory(req, List.of());
    }

    @Override
    public String buildPromptWithMemory(
            StudentQuestionRequest req,
            List<ChatMessage> history) {

        StringBuilder memory = new StringBuilder();

        for (ChatMessage msg : history) {
            memory.append("Q: ")
                    .append(msg.getQuestion())
                    .append("\nA: ")
                    .append(msg.getAnswer())
                    .append("\n\n");
        }

        return """
        You are a Chemistry teacher.
        Explain reactions, equations, and mechanisms.
        Avoid Physics and advanced Maths.

        If not Chemistry, say:
        "This question belongs to another subject."

        Grade: %s
        Topic: %s

        Question:
        %s
        """
                .formatted(
                        req.getGrade(),
                        req.getTopic(),
                        memory.toString(),
                        req.getQuestion()
                );
    }
}
