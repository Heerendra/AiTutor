package com.example.AiTutor.repository;

import com.example.AiTutor.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotesRepository
        extends JpaRepository<Notes, Long> {

    Optional<Notes> findBySessionId(Long sessionId);
}
