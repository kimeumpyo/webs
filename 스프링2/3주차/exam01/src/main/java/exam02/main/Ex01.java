package exam02.main;

import exam02.member.JoinService;
import exam02.member.Member;
import exam02.member.MemberListService;

import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) {
        JoinService joinService = new JoinService();
        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("1234");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        joinService.join(member);


        MemberListService listService = new MemberListService();
        listService.print();
    }
}
