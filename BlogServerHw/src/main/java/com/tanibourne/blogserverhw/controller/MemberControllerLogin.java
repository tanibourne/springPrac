package com.tanibourne.blogserverhw.controller;

import com.tanibourne.blogserverhw.models.Member;
import com.tanibourne.blogserverhw.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Profile({"login", "token"})
@RequiredArgsConstructor
@RestController
public class MemberControllerLogin {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/api/member/signup")
    public String signUp(@RequestBody Member member){
        String password =  bCryptPasswordEncoder.encode(member.getPassword());
        member.setPassword(password);

        memberRepository.save(member);

        return "회원 가입 완료";

    }
}
