package com.example.AiTutor.service.ai;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIClientService {

    private final ChatClient chatClient;

    public String generate(String prompt) {
        // Call OpenAI / Claude / Local LLM
        return chatClient
                .prompt()
                .user(prompt)
                .call()
                .content();
    }
}

