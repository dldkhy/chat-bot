package com.jc.llmservice.controller;

import com.jc.llmservice.model.GenerateRequest;
import com.jc.llmservice.service.LLMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/llm")
public class LLMController {
    @Autowired
    LLMService llmService;
    @PostMapping("/chat")
    ResponseEntity<String> chat(@RequestBody GenerateRequest generateRequest){
        System.out.println("进入了LLMController.chat"+generateRequest);
        return ResponseEntity.ok(llmService.sendMessage(generateRequest));
    }
}
