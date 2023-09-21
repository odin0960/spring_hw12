package com.goit12.todolist.controller;

import com.goit12.todolist.entity.DTO.NoteDTO;
import com.goit12.todolist.entity.Note;
import com.goit12.todolist.service.NoteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@Service
@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteServiceImpl noteService;

    @GetMapping("/list")
    public ModelAndView getList() {
        ModelAndView result = new ModelAndView("/note/list");
        List<NoteDTO> notes = noteService.listAll();
        result.addObject("notes", notes);
        return result;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public ModelAndView toEdit(@RequestParam(name = "id") Long id) {
        ModelAndView result = new ModelAndView("/note/edit");
        NoteDTO note = noteService.getById(id);
        result.addObject("note", note);
        return result;
    }

        @PostMapping("/edit")
        public String edit(@ModelAttribute NoteDTO note) {
            noteService.update(note);
            return "redirect:/note/list";
    }

//    @PostMapping("/edit")
//    public RedirectView update(@RequestParam ("id") Long id,
//                               @RequestParam String title,
//                               @RequestParam String content){
//        RedirectView redirectView = new RedirectView("/note/list");
//        Note note = new Note();
//        note.setId(id);
//        note.setTitle(title);
//        note.setContent(content);
//        noteService.update(note);
//        return redirectView;
//    }
}
