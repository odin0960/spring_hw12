package com.goit12.todolist.service;

import com.goit12.todolist.entity.DTO.NoteDTO;
import com.goit12.todolist.entity.Note;

import java.util.List;

public interface NoteService {
    public Note add(Note note);
    public List<NoteDTO> listAll();
    public NoteDTO getById(Long id);
    public Note update(NoteDTO note);
    public void deleteById(Long id);
}
