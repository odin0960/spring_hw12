package com.goit12.todolist.mappers;

import com.goit12.todolist.entity.DTO.CustomNote;
import com.goit12.todolist.entity.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface NoteMapper {
CustomNote toCustomNote(Note note);

}
