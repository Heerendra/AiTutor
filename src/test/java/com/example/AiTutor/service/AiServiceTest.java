package com.example.AiTutor.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class AiServiceTest {
    @Autowired
    private AiService aiService;
    @Test
    public void testGetResponse() {

        // When
        String response = aiService.getResponse("how to create spring boot app with multiple contexts?");

        // Then
        System.out.println(response);
    }

}
