package com.example.AiTutor.controller;


import com.example.AiTutor.service.NotesService;
import com.example.AiTutor.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/session")
@RequiredArgsConstructor
public class SessionController {
    private final SessionService sessionService;
    private final NotesService notesService;

    @PostMapping("/end/{sessionId}")
    public void endSession(@PathVariable Long sessionId) {
        sessionService.endSession(sessionId);
        notesService.createNotesAndPdf(sessionId);
    }
}
