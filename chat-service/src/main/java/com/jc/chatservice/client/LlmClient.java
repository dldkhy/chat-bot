package com.jc.chatservice.client;


import com.jc.llmservice.model.GenerateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name = "llmClient",url = "http://[::1]:8080")
public interface LlmClient {
    @PostMapping("/llm/chat")
    String chat(@RequestBody GenerateRequest generateRequest);

}
