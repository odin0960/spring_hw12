package com.goit12.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class TestController {
    @GetMapping("/test")
    public ModelAndView getTime() {
        ModelAndView result = new ModelAndView("test/time");
        result.addObject("now", LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss")));
        return result;
    }
}
