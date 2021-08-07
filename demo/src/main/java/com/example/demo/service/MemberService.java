package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service // Spring 컨테이너가 @Service를 보고 Service로 등록한다. //
public class MemberService {
    // 테스트 케이스 생성 단축 키 [Ctrl + Shift + T]
    private final MemberRepository memberRepository;

    // @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    /**
     * 회원가입
    */
    public Long join(Member member) {
        // 같은 이름이 있는 중복회원은 가입이 불가하다 //
        // Optional로 하는 이유는 Member 객체 위에 Optional 을 한번 더 감싼다. //
        // 그리고 Optional의 여러가지 메소드를 이용하면 더 편리하다. //

        // Optional<Member> result = memberRepository.findByName(member.getName());
        // result.ifPresent(m -> {
        //            throw new IllegalStateException("이미 존재하는 회원입니다.");
        //        });
        validateDuplicateMember(member); // 중복회원을 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
