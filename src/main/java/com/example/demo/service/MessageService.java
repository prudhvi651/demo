package com.example.demo.service;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dao.MessageRepository;
import com.example.demo.model.Message;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
 
@Service
public class MessageService implements IMessageService {
     
    @Autowired
    MessageRepository messageRepo;
 
    public void create(Message e) {
    	
    	System.out.println("id=="+e.getId());
    	
    	System.out.println("message=="+e.getMessage());
    	
    	String uri="http://localhost:8888/postMessage/{message}";
       
       UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(uri).queryParam("message", e.getMessage());
       String uriBuilder = builder.build().encode().toUriString();
        	   
    	
    	HttpEntity<String> entity=new HttpEntity<String>(e.getMessage());
    	
    	RestTemplate template=new RestTemplate();
    	
    	
    	ResponseEntity<Integer> responseEntity=template.exchange(uriBuilder, HttpMethod.POST, entity, Integer.class);
    	
    	if(responseEntity.getBody()==200) {
    		messageRepo.save(e).subscribe();
    	}
    	
    	
    }
 
    public Mono<Message> findById(Integer id) {
        return messageRepo.findById(id);
    }
    
    public Flux<Message> findAll() {
        return messageRepo.findAll();
    }
 
   
 
}