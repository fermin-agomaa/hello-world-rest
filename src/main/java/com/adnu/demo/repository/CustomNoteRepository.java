package com.adnu.demo.repository;

import com.adnu.demo.model.Note;

public interface CustomNoteRepository {
	
	public Note getNoteById(Long id);
	
	public Note createNote(Note note);
	
	public Note updateNote(Note note);
	
	public Boolean deleteNote(Long id);

}
