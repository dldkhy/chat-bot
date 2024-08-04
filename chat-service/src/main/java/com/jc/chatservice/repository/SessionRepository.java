package com.jc.chatservice.repository;

import com.jc.chatservice.model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface SessionRepository extends MongoRepository<Session, String> {
    List<Session> findAllByUserId(String userId);
}
