package exam03.config;

import exam03.member.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {AppCtx3.class})
public class AppCtx2 {

    @Bean // 관리할 객체임을 알려줌
    public JoinService joinService(){
        return new JoinService();
    }

    @Bean
    public MemberListService listService(){
        return new MemberListService();
    }
}
