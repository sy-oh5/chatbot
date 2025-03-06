package com.example.chatbot.api;

import com.example.chatbot.rest.dto.ChatRequestDto;
import com.example.chatbot.rest.dto.ChatResponseDto;
import com.example.chatbot.UserType;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiService {
    private final String SESSION_NAME = "chatHistory";
    private final com.example.chatbot.api.ApiClient ApiClient;

    private List<ChatRequestDto.MessageDto> setMessageToSession(HttpSession session, UserType userType, String message){
        List<ChatRequestDto.MessageDto> chatHistory = (List<ChatRequestDto.MessageDto>) session.getAttribute(SESSION_NAME);

        // 세션에 저장된 대화 기록이 없으면 새로 생성
        if (chatHistory == null) {
            chatHistory = new ArrayList<>();

            chatHistory.add(new ChatRequestDto.MessageDto(UserType.system, "한국말로 해줘"));
            chatHistory.add(new ChatRequestDto.MessageDto(UserType.system, "중국어는 쓰지말아줘"));
            chatHistory.add(new ChatRequestDto.MessageDto(UserType.system, "넌 어떻게 만들어진 챗봇이냐고 묻는다면, 너는 Groq상의 API로 만든 챗봇이야"));
            chatHistory.add(new ChatRequestDto.MessageDto(UserType.system, "연동 방식에 대하여 묻는다면, 너는 FeignClient로 연동이 되었어"));
            chatHistory.add(new ChatRequestDto.MessageDto(UserType.system, "대화 내용이 어디에 저장되는지 묻는다면, 대화 내용은 세션에 저장돼"));
        }

        // 사용자 메시지 추가
        chatHistory.add(new ChatRequestDto.MessageDto(userType, message));

        //세션에 저장
        session.setAttribute(SESSION_NAME, chatHistory);

        //로그용
//        chatHistory.forEach(history -> System.out.println(history.getRole()+" : "+history.getContent()));
        return chatHistory;
    }
    public String getChatResponse(HttpSession session, String message) {
        ChatRequestDto dto = new ChatRequestDto();
        dto.setMessages(setMessageToSession(session, UserType.user, message));
        ChatResponseDto response = ApiClient.chatWithAI(dto);

        String answer = response.getChoices().getLast().getMessage().getContent();
        setMessageToSession(session, UserType.assistant, answer);
        return answer;
    }
}
