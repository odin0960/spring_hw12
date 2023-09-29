package com.goit12.todolist.service.impl;

import com.goit12.todolist.entity.DTO.UserDTO;
import com.goit12.todolist.entity.Note;
import com.goit12.todolist.entity.User;
import com.goit12.todolist.mappers.UserMapper;
import com.goit12.todolist.repository.UserRepository;
import com.goit12.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserDTO> userList() {
        return userRepository.findAll().stream().map(mapper::toUserDto).toList();
    }

    @Override
    public UserDTO getByName(String username) {
//        return userRepository.findByUsername(username).map(mapper::toUserDto);
        return mapper.toUserDto(userRepository.findByUsername(username).orElseThrow());
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
