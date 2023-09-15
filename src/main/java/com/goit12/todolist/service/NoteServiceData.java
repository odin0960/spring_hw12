package com.goit12.todolist.service;

import com.goit12.todolist.entity.Note;
import com.goit12.todolist.repository.NoteRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class NoteServiceData {
    private final NoteRepository noteRepository;

@PostConstruct
    public void init() {
    System.out.println(noteRepository.getClass());
}

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note getById(Long id) {
        return noteRepository.findById(id).orElseThrow();
    }

    public Note update(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public void deleteNote(Note note) {
        noteRepository.delete(note);
    }

}
