package com.example.AiTutor.service;

import com.example.AiTutor.model.ChatMessage;
import com.example.AiTutor.model.LearningSession;
import com.example.AiTutor.model.StudentAnswerResponse;
import com.example.AiTutor.model.StudentQuestionRequest;
import com.example.AiTutor.repository.ChatRepository;
import com.example.AiTutor.service.ai.AIClientService;
import com.example.AiTutor.subject.SubjectPromptFactory;
import com.example.AiTutor.subject.SubjectPromptStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeachingAIService {

    private static final int MAX_MEMORY_MESSAGES = 10;

    private final SubjectPromptFactory factory;
    private final AIClientService aiClient;
    private final SessionService sessionService;
    private final ChatRepository chatRepository;

    public StudentAnswerResponse teach(StudentQuestionRequest request) {

        LearningSession session =
                sessionService.getOrCreateSession(
                        request.getStudentId(),
                        request.getSubject()
                );

        // 1️⃣ Load FULL history from DB
        List<ChatMessage> history =
                chatRepository.findBySessionIdOrderByTimestampAsc(
                        session.getId()
                );

        // 2️⃣ LIMIT memory for AI (IMPORTANT LINE)
        history = history.stream()
                .skip(Math.max(0, history.size() - MAX_MEMORY_MESSAGES))
                .toList();

        // 3️⃣ Build subject-specific prompt with memory
        SubjectPromptStrategy teacher =
                factory.getTeacher(request.getSubject());

        String prompt =
                teacher.buildPromptWithMemory(request, history);

        // 4️⃣ Call AI
        String answer = aiClient.generate(prompt);

        // 5️⃣ Save FULL chat (no trimming here)
        ChatMessage message = new ChatMessage();
        message.setSessionId(session.getId());
        message.setQuestion(request.getQuestion());
        message.setAnswer(answer);
        message.setTimestamp(LocalDateTime.now());

        chatRepository.save(message);

        return new StudentAnswerResponse(
                request.getSubject(),
                answer
        );
    }


}

