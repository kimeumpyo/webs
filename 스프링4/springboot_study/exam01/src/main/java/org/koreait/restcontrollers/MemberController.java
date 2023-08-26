package org.koreait.restcontrollers;

import lombok.extern.slf4j.Slf4j;
import org.koreait.models.member.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/member")
public class MemberController {
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
    @GetMapping("/list")
    public List<Member> list(){
        List<Member> members = new ArrayList<>();
        for (int i = 1; i  <= 10; i++){
            Member member = Member.builder()
                    .userNo(Long.valueOf(i))
                    .userId("user" + i)
                    .userPw("123456")
                    .userNm("사용자" + i)
                    .email("user" + i + "@test.org")
                    .regDt(LocalDateTime.now())
                    .build();
            members.add(member);
        }
        return members;
    }
    @GetMapping("/test1")
    public String test1(){
        return "Hello"; // 문자열
    }
    @GetMapping("/test2")
    public void test2(){
        log.info("내부 처리...");
    }
}
