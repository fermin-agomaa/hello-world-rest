/**
 * 
 */
package com.adnu.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adnu.demo.model.Note;
import com.adnu.demo.repository.NoteRepository;

/**
 * @author Fermin Agomaa III
 *
 */
@RestController
public class NoteController {
	
	@Autowired
	private NoteRepository noteRepository;

	@GetMapping("/notes/{id}")
	public Note getNoteById(@PathVariable Long id)
	{
		Optional<Note> result = noteRepository.findById(id);
		Note note = new Note();
		
		if(!result.isEmpty())
		{
			note = result.get();
		}
		
		return note;
	}
	
	@PostMapping("/notes")
	public Note createNote(@RequestBody Note n)
	{	
		return noteRepository.save(n);
	}
	
	@PutMapping("/notes/{id}")
	public Note updateNote(@PathVariable Long id, @RequestBody Note n)
	{
		Optional<Note> result = noteRepository.findById(id);
		Note note = new Note();
		
		if(!result.isEmpty())
		{
			note = result.get();
			
			note.setName(n.getName());
			note.setDescription(n.getDescription());
			
			return noteRepository.save(note);
			
		}
		else return n;
	}
	
	@DeleteMapping("/notes/{id}")
	Boolean deleteNote(@PathVariable Long id)
	{
		noteRepository.deleteById(id);
		
		return true; 
	}
}
