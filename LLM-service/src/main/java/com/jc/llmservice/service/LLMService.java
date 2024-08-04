package com.jc.llmservice.service;


import com.jc.llmservice.client.OllamaClient;
import com.jc.llmservice.model.GenerateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LLMService {
    @Autowired
    private OllamaClient ollamaClient;
    public String sendMessage(GenerateRequest generateRequest) {
        return ollamaClient.Chat(generateRequest);
    }


}
