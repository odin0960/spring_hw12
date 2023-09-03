package com.goit12.todolist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final Map<Long, Note> notesBase;

    List<Note> listAll() {
        List<Note> list = new ArrayList<Note>(notesBase.values());
        return list;
    }

    Note add(Note note) {
        long id;
        do {
            id = (long) (Math.random() * 1000 + 1);
        } while (notesBase.containsKey(id));

        note.setId(id);
        notesBase.put(id, note);

        return note;
    }

    void deleteById(long id) {
        if (notesBase.containsKey(id)) {
            notesBase.remove(id);
        } else {
            throw new IllegalArgumentException("Такий індекс відсутній");
        }
    }

    void update(Note note) {
        if (notesBase.containsKey(note.getId())) {
            notesBase.replace(note.getId(), note);
        } else {
            throw new IllegalArgumentException("Така нотатка відсутня");
        }
    }

    Note getById(long id) {
        if (notesBase.containsKey(id)) {
            return notesBase.get(id);
        } else {
            throw new IllegalArgumentException("Така нотатка відсутня");
        }
    }

}
