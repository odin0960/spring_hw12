package com.goit12.todolist;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class Note {
    long id; //автогенерація
    String title;
    String content;

}
