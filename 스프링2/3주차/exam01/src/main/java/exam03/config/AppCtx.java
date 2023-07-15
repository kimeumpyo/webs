package exam04.config;

import exam04.member.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppCtx {
    @Bean // Bean : 스프링 관리 객체임을 알림
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public JoinService joinService(){
        return new JoinService(memberDao());
    }

    @Bean
    public MemberListService listService(){
        return new MemberListService(memberDao());
    }
}
