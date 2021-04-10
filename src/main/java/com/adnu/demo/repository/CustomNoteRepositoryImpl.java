/**
 * 
 */
package com.adnu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adnu.demo.model.Note;

/**
 * @author Fermin Agomaa III
 *
 */
@Repository
@Transactional
public class CustomNoteRepositoryImpl implements CustomNoteRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Note getNoteById(Long id) {	
		
		Note note = entityManager.find(Note.class, id);
		
		return note;
	}

	@Override
	public Note createNote(Note note) {

		Note newNote = null;
		
		Boolean valid = Boolean.TRUE;
		
		if(note.getName() == null || note.getDescription() == null)
		{
			valid = Boolean.FALSE;
		}
		
		if(valid)
		{
			newNote = new Note();
			newNote.setName(note.getName());
			newNote.setDescription(note.getDescription());
			
			entityManager.persist(newNote);
		}

		return newNote;
	}

	@Override
	public Note updateNote(Note note) {
		
		Note newNote = null;
		
		Boolean valid = Boolean.TRUE;
		
		newNote = entityManager.find(Note.class, note.getId());
		
		if(note.getId() != null || note.getName() == null || note.getDescription() == null)
		{
			valid = Boolean.FALSE;
		}
		
		if(valid)
		{	
			newNote.setName(note.getName());
			newNote.setDescription(note.getDescription());
			
			entityManager.persist(newNote);

		}
		
		return newNote;
	}

	@Override
	public Boolean deleteNote(Long id) {

		Boolean isDeleted = Boolean.FALSE;
		Note noteToDelete;
		
		try {
		
			noteToDelete = entityManager.find(Note.class, id);
			
			if(noteToDelete != null)
			{
				entityManager.remove(noteToDelete);
				isDeleted = Boolean.TRUE;
					
			}
		}
		catch(IllegalArgumentException e)
		{}
		catch(EmptyResultDataAccessException e)
		{}
		
		return isDeleted;
	}

}
