package com.goit12.todolist.entity;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
public class Note {
    long id; //автогенерація
    String title;
    String content;

}
