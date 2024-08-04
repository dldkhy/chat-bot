package com.jc.chatservice.repository;
import com.jc.chatservice.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findBySessionId(Long sessionId);

}
