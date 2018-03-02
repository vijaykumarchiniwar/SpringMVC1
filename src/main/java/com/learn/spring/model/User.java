package com.learn.spring.model;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	public User() {
		
	}
	
	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}

	private String name;
	private String id;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
