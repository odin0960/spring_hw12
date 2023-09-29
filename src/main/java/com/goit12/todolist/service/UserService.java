package com.goit12.todolist.service;

import com.goit12.todolist.entity.DTO.UserDTO;
import com.goit12.todolist.entity.User;
import java.util.List;

public interface UserService {
    public User add(User user);
    public List<UserDTO> userList();
    public UserDTO getByName(String username);
    public User update(User user);
    public void delete(User user);
}
