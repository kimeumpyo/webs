package exam06.config;

import exam06.Message2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppCtx2 {
    @Bean(initMethod = "init", destroyMethod = "close")
    @Scope("prototype") // 여러 객체를 생성!
    public Message2 message2(){
        return new Message2();
    }
}
