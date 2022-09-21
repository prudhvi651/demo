package com.example.demo.service;

import com.example.demo.model.Message;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
public interface IMessageService
{
    void create(Message e);
     
    Mono<Message> findById(Integer id);
    
    public Flux<Message> findAll();

}