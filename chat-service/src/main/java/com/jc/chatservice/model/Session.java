package com.jc.chatservice.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "Sessions")
@Getter
@Setter
public class Session {
    @Id
    private String id;
    @Field("user_id")
    private Long userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
