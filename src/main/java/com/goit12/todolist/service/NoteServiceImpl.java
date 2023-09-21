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
public class NoteServiceImpl implements NoteService{
    private final NoteRepository noteRepository;
    private final NoteMapper mapper;

    @Override
    public Note add(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<NoteDTO> listAll() {
//        return noteRepository.findAll().stream().map(mapper::toCustomNote).collect(Collectors.toList());
        return noteRepository.findAll().stream().map(mapper::toNoteDto).toList();
    }

    @Override
    public NoteDTO getById(Long id) {
        return noteRepository.findById(id).map(mapper::toNoteDto).orElseThrow();
    }

    @Override
    public Note update(NoteDTO note) {
        Note entity = mapper.toEntity(note);
        return noteRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    public void deleteNote(Note note) {
        noteRepository.delete(note);
    }

}
