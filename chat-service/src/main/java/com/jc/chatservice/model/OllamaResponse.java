package com.jc.chatservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OllamaResponse {
    private String model;
    private Message messages;
}
