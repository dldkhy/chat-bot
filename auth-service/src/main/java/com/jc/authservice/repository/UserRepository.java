package com.jc.authservice.repository;

import com.jc.authservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllById(String userId);
    User findByUsername(String username);
}
