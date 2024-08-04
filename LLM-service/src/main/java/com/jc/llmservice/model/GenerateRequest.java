package com.jc.llmservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateRequest {
    private String model;
    private String prompt;
    private boolean stream;
}
