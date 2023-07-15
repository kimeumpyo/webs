package exam04.main;

import exam04.config.AppCtx;
import exam04.member.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        JoinService joinService = ctx.getBean(JoinService.class);

        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("1234");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        joinService.join(member);

        MemberListService listService = ctx.getBean(MemberListService.class);
        listService.print();

        ctx.close();
    }
}
