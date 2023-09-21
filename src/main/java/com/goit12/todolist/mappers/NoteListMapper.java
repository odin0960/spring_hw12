package com.goit12.todolist.mappers;


import com.goit12.todolist.entity.DTO.NoteDTO;
import com.goit12.todolist.entity.Note;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = NoteMapper.class)
public interface NoteListMapper {
        List<NoteDTO> toListNoteDto(List<Note> noteList);
}
