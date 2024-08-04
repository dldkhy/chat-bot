package com.jc.chatservice.controller;

import com.jc.chatservice.model.Message;
import com.jc.chatservice.service.ChatService;
import com.jc.llmservice.model.GenerateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping("/messages")
    public Message saveMessage(@RequestBody Message message) {
        return chatService.saveMessage(message);
    }
    @PostMapping("/sendmessages")
    public Message sendMessage(@RequestBody GenerateRequest generateRequest) { return chatService.sendMessage(generateRequest);}

}
