package com.goit12.todolist.entity;

import lombok.Data;

@Data
public class Note {
    long id; //автогенерація
    String title;
    String content;

}
