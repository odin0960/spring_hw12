package com.goit12.todolist.controller;

import com.goit12.todolist.entity.User;
import com.goit12.todolist.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RequiredArgsConstructor
@Service
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping("/reg")
    public ModelAndView regNewUser(User user) {
        ModelAndView result = new ModelAndView("/user/reg");
        result.addObject("user", user);
        return result;
//        return "reg";
    }

    @PostMapping("/reg")
    public String saveNewUser(@ModelAttribute User user) {
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
