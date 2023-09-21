package com.goit12.todolist.mappers;

import com.goit12.todolist.entity.DTO.UserDTO;
import com.goit12.todolist.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDto(User user);
    User toEntity(UserDTO userDto);
}
