package com.example.AiTutor.service;

import com.example.AiTutor.model.LearningSession;
import com.example.AiTutor.repository.SessionRepository;
import com.example.AiTutor.subject.SubjectType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository repository;

    public LearningSession getOrCreateSession(Long studentId, SubjectType subject) {

        return repository.findActiveSession(studentId, subject)
                .orElseGet(() -> {
                    LearningSession session = new LearningSession();
                    session.setStudentId(studentId);
                    session.setSubject(subject);
                    session.setActive(true);
                    session.setStartedAt(LocalDateTime.now());
                    return repository.save(session);
                });
    }

    public void endSession(Long sessionId) {
        LearningSession session = repository.findById(sessionId).orElseThrow();
        session.setActive(false);
        session.setEndedAt(LocalDateTime.now());
        repository.save(session);
    }

    public String generatePdf(String content, Long sessionId) {

        String path = "notes/session_" + sessionId + ".pdf";

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        document.open();
        document.add(new Paragraph(content));
        document.close();

        return path;
    }

}

