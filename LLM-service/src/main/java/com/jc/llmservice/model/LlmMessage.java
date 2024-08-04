package com.jc.llmservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LlmMessage {
    private String role;
    private String context;
}
