package com.example.demo;

import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import com.example.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Spring 빈에 직접 등록 하는 설정파일
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // MemberRepository 는 인터페이스 일 뿐 //
        // MemoryMemberRepository 가 실질적인 저장소 임 //
        return new MemoryMemberRepository();
    }
}
