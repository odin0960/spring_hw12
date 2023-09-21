package com.goit12.todolist.entity.DTO;

import lombok.Data;


@Data
public class UserDTO {
    private Long Id;
    private String username;
//    private String password;
    private String role;
}
