package com.goit12.todolist.controller;

import com.goit12.todolist.entity.DTO.NoteDTO;
import com.goit12.todolist.entity.Note;
import com.goit12.todolist.entity.User;
import com.goit12.todolist.service.impl.NoteServiceImpl;
import com.goit12.todolist.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

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

    @GetMapping("/reg")
    public ModelAndView regNewUser(User user) {
        ModelAndView result = new ModelAndView("/note/reg");
        result.addObject("user", user);
        return result;
//        return "reg";
    }

    @PostMapping("/reg")
    public String saveNewUser(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.add(user);
        return "redirect:/login";
    }

//    @GetMapping("/admin")
//    public ModelAndView superAdminOnly() {
//        if (!authService.hasAuthority("admin")) {
//            return new ModelAndView("forbidden");
//        }
//        return new ModelAndView("admin");
//    }

}
