package com.example.demo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
 
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Document
public class Message {
 
    @Id
    int id;
    String message;
    
 
    
 
    public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	@Override
    public String toString() {
        return "Message [id=" + id + ", message=" + message + "]";
    }
}
