package exam06.config;

import exam06.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
    @Bean
    public Message message(){
        return new Message();
    }
}
