package com.adnu.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adnu.demo.model.Note;

@RestController
public class HelloWorldController {

	@RequestMapping("/")
	public String hello()
	{
		return "Hello World!";
	}
	
	
	@RequestMapping("/note")
	public Note note()
	{
		Note note = new Note();
		note.setId(1l);
		note.setName("Test Note");
		note.setDescription("This is a test description");
		
		return note;
		
	}
}
