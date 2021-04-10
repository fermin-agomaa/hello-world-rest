package com.adnu.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adnu.demo.model.Note;
import com.adnu.demo.repository.NoteRepository2;

@RestController
public class NoteController2 {
	
	@Autowired
	private NoteRepository2 noteRepository2;

	@GetMapping("/notes2/{id}")
	public Note getNoteById(@PathVariable Long id, HttpServletResponse response)
	{
		Note note = noteRepository2.getNoteById(id);
		
		if(note != null)
		{
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		
		return note;
	}
	
	@PostMapping("/notes2")
	public Note createNote(@RequestBody Note n, HttpServletResponse response)
	{	
		Note note = noteRepository2.createNote(n);
		
		if(note != null)
		{
			response.setStatus(HttpServletResponse.SC_CREATED);
		}
		else response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		
		return note;
	}
	
	@PutMapping("/notes2/{id}")
	public Note updateNote(@PathVariable Long id, @RequestBody Note n, HttpServletResponse response)
	{
		n.setId(id);
		
		Note note = noteRepository2.updateNote(n);
		
		if(note != null)
		{
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		
		return note;
	}
	
	@DeleteMapping("/notes2/{id}")
	Boolean deleteNote(@PathVariable Long id, HttpServletResponse response)
	{
		Boolean isDeleted = noteRepository2.deleteNote(id);
		
		if(isDeleted)
		{
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		
		return isDeleted; 
	}
}
