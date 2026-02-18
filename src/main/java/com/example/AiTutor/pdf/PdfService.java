package com.example.AiTutor.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class PdfService {

    private static final String BASE_DIR = "notes/";

    public String generatePdf(String content, Long sessionId) {

        try {
            Files.createDirectories(Paths.get(BASE_DIR));

            String filePath = BASE_DIR + "session_" + sessionId + ".pdf";

            Document document = new Document();
            PdfWriter.getInstance(
                    document,
                    new FileOutputStream(filePath)
            );

            document.open();
            document.add(new Paragraph(content));
            document.close();

            return filePath;

        } catch (Exception e) {
            throw new RuntimeException("Failed to generate PDF", e);
        }
    }
}

