package com.example.chatbot.api;

import com.example.chatbot.rest.dto.ChatRequestDto;
import com.example.chatbot.rest.dto.ChatResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "huggingface-client", url = "https://api.groq.com/openai/v1/chat/completions"
,configuration = {
        ApiConfig.class})
public interface ApiClient {

    @PostMapping
    ChatResponseDto chatWithAI(@RequestBody ChatRequestDto dto);
}
