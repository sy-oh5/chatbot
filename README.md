# chatbot
+ groq 사 오픈 api 연동
+ 연동 방식은 netflix에서 개발한 feignClient 라이브러리를 사용
+ 대화 내용은 세션에 저장됨  


### ChatRequestDto.MessageDto의 role 역할
#### system : 챗봇의 기본 설정
#### user : 사용자가 입력하는 메시지
#### assistant : 챗봇의 응답 메시지

#### system에 입력 값을 주입 시키면 그에 따른 답변을 받을 수 있음
![image](https://github.com/user-attachments/assets/32f1d782-59f2-4e26-b89b-ab00945cda96)



##### 삽질
###### 처음 계획은 hugging face api사를 연동하려고 했으나, 무료 제한이 생각보다 빨리 끝나버렸다.<br>로컬에서 실행시키면 무료라고 하길래 docker image 생성하여 container 생성할려고 하니 용량이 400gb...<br>좀 더 가벼운 다른 모델로 다시 시도할려고 했으나 HW 요구사항 부족 ㅠㅠ<br>그러던 중 groq사의 api를 찾았다..<br>비록 무료 버전이라 성능적으로 좋다고 할 순 없지만 찍먹은 할 수 있는 수준이였다.
