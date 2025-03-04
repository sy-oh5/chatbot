package com.example.chatbot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatbotUIController {

    @GetMapping("/")
    public String chatbotPage() {
        return "chatbot";  // templates/chatbot.html을 반환
    }
}
