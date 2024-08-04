package com.jc.llmservice.model;


import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class OllamaRequest {
    private String model;
    private LlmMessage messages;
}
