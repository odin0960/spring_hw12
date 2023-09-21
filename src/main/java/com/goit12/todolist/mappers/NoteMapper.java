package com.goit12.todolist.mappers;

import com.goit12.todolist.entity.DTO.NoteDTO;
import com.goit12.todolist.entity.Note;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {
//    @Mapping(target = "shortContent", source = "content")
    NoteDTO toNoteDto(Note note);
    Note toEntity(NoteDTO noteDto);

//    List<NoteDTO> asListNoteDto(List<Note> noteList);

}
