package com.goit12.todolist.service.impl;

import com.goit12.todolist.entity.DTO.UserDTO;
import com.goit12.todolist.entity.User;
import com.goit12.todolist.mappers.UserMapper;
import com.goit12.todolist.repository.UserRepository;
import com.goit12.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public List<UserDTO> userList() {
        return null;
    }

    @Override
    public UserDTO getByName(String username) {
        return null;
    }

    @Override
    public User update(UserDTO user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }
}
