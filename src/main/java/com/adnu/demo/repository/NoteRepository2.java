package com.adnu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adnu.demo.model.Note;

public interface NoteRepository2 extends JpaRepository<Note, Long>, CustomNoteRepository {

}
