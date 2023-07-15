package exam03.config;

import exam03.member.MemberDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class AppCtx3 {
    @Bean
    @Qualifier("memberDao1")
    public MemberDao memberDao(){
        return new MemberDao();
    }

    @Bean
    @Qualifier("memberDao2")
    public MemberDao memberDao2(){
        return new MemberDao();
    }

    @Bean
    public DateTimeFormatter dateTimeFormatter(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");

        return formatter;
    }
}
