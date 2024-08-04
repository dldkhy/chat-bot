package com.jc.llmservice.client;

import com.jc.llmservice.model.GenerateRequest;
import com.jc.llmservice.model.LlmMessage;
import com.jc.llmservice.model.OllamaRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "ollamaClient",url="http://localhost:11434")
public interface OllamaClient {
    @PostMapping("api/generate")
    String Chat(@RequestBody GenerateRequest generateRequest);
}
