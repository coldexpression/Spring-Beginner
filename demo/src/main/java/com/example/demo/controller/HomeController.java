package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // localhost:8080 으로 들어올 때 home함수를 호출하겠다 //
    public String home() {
        return "home"; // templates 에 있는 home.html 파일을 오픈한다 //
    }
}
