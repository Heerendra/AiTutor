package com.example.AiTutor.repository;

import com.example.AiTutor.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository
        extends JpaRepository<ChatMessage, Long> {

    /**
     * Fetch complete chat history for a session
     * Ordered so memory flows correctly
     */
    List<ChatMessage> findBySessionIdOrderByTimestampAsc(Long sessionId);
}

