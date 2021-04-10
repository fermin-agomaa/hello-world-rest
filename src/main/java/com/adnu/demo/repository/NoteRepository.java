/**
 * 
 */
package com.adnu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adnu.demo.model.Note;

/**
 * @author Fermin Agomaa III
 *
 */
public interface NoteRepository extends JpaRepository<Note, Long> 
{

}
