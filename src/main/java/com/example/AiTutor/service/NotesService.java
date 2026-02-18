package com.example.AiTutor.service;

import com.example.AiTutor.model.ChatMessage;
import com.example.AiTutor.model.Notes;
import com.example.AiTutor.pdf.PdfService;
import com.example.AiTutor.repository.ChatRepository;
import com.example.AiTutor.repository.NotesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotesService {

    private final ChatRepository chatRepository;
    private final NotesRepository notesRepository;
    private final PdfService pdfService;

    public String generateNotes(List<ChatMessage> messages) {

        StringBuilder notes = new StringBuilder();

        for (ChatMessage msg : messages) {
            notes.append("Q: ").append(msg.getQuestion()).append("\n");
            notes.append("A: ").append(msg.getAnswer()).append("\n\n");
        }

        return notes.toString();
    }

    @Transactional
    public void createNotesAndPdf(Long sessionId) {

        // 1️⃣ Fetch full chat history (NOT trimmed)
        List<ChatMessage> messages =
                chatRepository.findBySessionIdOrderByTimestampAsc(sessionId);

        if (messages.isEmpty()) {
            throw new IllegalStateException(
                    "No chat history found for session " + sessionId);
        }

        // 2️⃣ Build notes content
        String notesContent = buildNotes(messages);

        // 3️⃣ Generate PDF
        String pdfPath = pdfService.generatePdf(notesContent, sessionId);

        // 4️⃣ Save notes metadata
        Notes notes = new Notes();
        notes.setSessionId(sessionId);
        notes.setContent(notesContent);
        notes.setPdfPath(pdfPath);

        notesRepository.save(notes);
    }

    /**
     * Converts chat messages into readable notes
     */
    private String buildNotes(List<ChatMessage> messages) {

        StringBuilder notes = new StringBuilder();

        notes.append("STUDY NOTES\n");
        notes.append("====================\n\n");

        int count = 1;
        for (ChatMessage msg : messages) {

            notes.append(count++).append(". Question:\n");
            notes.append(msg.getQuestion()).append("\n\n");

            notes.append("Answer:\n");
            notes.append(msg.getAnswer()).append("\n");
            notes.append("----------------------------\n\n");
        }

        return notes.toString();
    }
}

