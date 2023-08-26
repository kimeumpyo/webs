package org.koreait.controllers;

import org.koreait.models.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class MainController {
    @GetMapping("/") // 메인페이지
    public String index(){
        System.out.println("테스트");
         return "index";
    }
    @ResponseBody
    @GetMapping("/info")
    public Member info(){
        Member member = Member.builder()
                .userNo(1L)
                .userId("user01")
                .userPw("123456")
                .userNm("사용자01")
                .email("user01@test.org")
                .regDt(LocalDateTime.now())
                .build();
        return member;
    }
}
