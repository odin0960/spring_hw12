package com.goit12.todolist.service;

import com.goit12.todolist.entity.DTO.NoteDTO;
import com.goit12.todolist.entity.Note;
import com.goit12.todolist.mappers.NoteMapper;
import com.goit12.todolist.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final NoteMapper mapper;

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public List<NoteDTO> listAll() {
//    public List<Note> listAll() {
//        return noteRepository.findAll();
//        return noteRepository.findAll().stream().map(mapper::toCustomNote).collect(Collectors.toList());
        return noteRepository.findAll().stream().map(mapper::toNoteDto).toList();
    }

    public NoteDTO getById(Long id) {
//        return noteRepository.findById(id).orElseThrow();
        return noteRepository.findById(id).map(mapper::toNoteDto).orElseThrow();
    }

    public Note update(NoteDTO note) {
        Note entity = mapper.toEntity(note);
        return noteRepository.save(entity);
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    public void deleteNote(Note note) {
        noteRepository.delete(note);
    }

}
