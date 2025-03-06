package com.example.chatbot.rest.dto;

import com.example.chatbot.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRequestDto {
    private String model = "llama-3.3-70b-versatile";  // 기본 모델 지정
    private List<MessageDto> messages;  // 대화 내역

    @Getter
    public static class MessageDto {

        public MessageDto(UserType role, String content){
            this.role = role;
            this.content = content;
        }
        private UserType role;
        private String content;
    }
}
