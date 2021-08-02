package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") // HTTP의 GET 메소드를 나타낸다.
    public String hello(Model model) {
        model.addAttribute("data","hello!");
        return "hello";
    }
}
