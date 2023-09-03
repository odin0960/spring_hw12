package com.goit12.todolist;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class NoteService {

    private final Map<Long, Note> notesBase;

    List<Note> listAll() {
        return new ArrayList<>(notesBase.values());
    }

    Note add(Note note) {
        long id;
        if (notesBase.isEmpty()) {
            id = 1L;
        } else {
            id = Collections.max(notesBase.keySet()) + 1;
        }

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
