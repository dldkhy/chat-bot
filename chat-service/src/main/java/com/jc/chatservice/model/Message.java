package com.jc.chatservice.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Messages")
@Getter
@Setter
public class Message {
    @Id
    private String id;
    @Field("session_id")
    private Long sessionId;
    private String content;
    private String sender;
}
