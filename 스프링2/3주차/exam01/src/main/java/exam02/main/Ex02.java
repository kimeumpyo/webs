package exam02.main;

import exam02.member.*;

import java.time.LocalDateTime;

public class Ex02 {
    public static void main(String[] args) {

        JoinService joinService = ServiceManager.getInstance().joinService();

        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("1234");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        joinService.join(member);


        MemberListService listService = ServiceManager.getInstance().listService(); // ??
        listService.print();
    }
}
