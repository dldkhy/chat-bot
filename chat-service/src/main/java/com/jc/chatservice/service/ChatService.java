package com.jc.chatservice.service;

import com.jc.chatservice.client.LlmClient;
import com.jc.chatservice.model.Message;
import com.jc.chatservice.model.Session;
import com.jc.chatservice.repository.MessageRepository;
import com.jc.chatservice.repository.SessionRepository;
import com.jc.llmservice.model.GenerateRequest;
import com.jc.llmservice.model.LlmMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private LlmClient llmClient;

    public Message saveMessage(Message message){
        return messageRepository.save(message);
    }

    public List<Message> getMessageBySessionId(Long sessionId) {
        return messageRepository.findBySessionId(sessionId);
    }

    public List<Session> getSessionByUserId(String userId) {
        return sessionRepository.findAllByUserId(userId);
    }

    public Message sendMessage(GenerateRequest generateRequest){
        //调用llm那边的微服务
        System.out.println("进入ChatService.sendMessage");
        Message message = new Message();
        String prcessedContent = llmClient.chat(generateRequest);
        System.out.println("完成了llmClient.chat");
        message.setContent(prcessedContent);

        //现在做不了session管理 所以user这一个选项完全没意义
        return messageRepository.save(message);
    }



}
