package com.example.AiTutor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AiService {

    private final ChatClient chatClient;

    public String getResponse(String userInput) {
        // Use the chatClient to get a response from the AI model
        return chatClient
                .prompt()
                .user(userInput)
                .call()
                .content();
    }
}
