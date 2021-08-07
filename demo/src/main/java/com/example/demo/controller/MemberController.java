package com.example.demo.controller;

import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
// Spring 컨테이너가 생성될 때, MembrController가 생성된다.
public class MemberController {
    private final MemberService memberService;

    @Autowired
    // MemberController 가 생성이 될 때, Spring 빈에 등록되어 있는 MemberService 객체를 넣어준다. //
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
