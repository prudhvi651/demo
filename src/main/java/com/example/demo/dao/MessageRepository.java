package com.example.demo.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.demo.model.Message;
 
public interface MessageRepository extends ReactiveMongoRepository<Message, Integer> {
   
}