package exam03.main;

import exam03.config.AppCtx;
import exam03.member.JoinService;
import exam03.member.Member;
import exam03.member.MemberListService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Ex02 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        JoinService joinService = ctx.getBean("joinService", JoinService.class);
        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("1234");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());   // 시간

        joinService.join(member);

        MemberListService listService = ctx.getBean("listService", MemberListService.class);
        listService.print();

        ctx.close();
    }
}
