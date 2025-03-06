package com.example.chatbot.rest;

import com.example.chatbot.api.ApiService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ChatbotController {
    private final ApiService apiService;

    @PostMapping("/chat")
    public ResponseEntity<String> chat(HttpSession session, @RequestBody String message){
        return ResponseEntity.ok(apiService.getChatResponse(session, message));
    }
}
