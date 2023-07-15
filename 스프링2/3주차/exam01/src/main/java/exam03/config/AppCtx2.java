package exam03.config;

import exam03.member.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx2 {
    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    public JoinService joinService(){
        return new JoinService();
    }

    @Bean
    public MemberListService listService(){
        return new MemberListService();
    }
}
