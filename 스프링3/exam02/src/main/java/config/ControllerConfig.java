package config;

import controllers.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// 하위에 있는 모든 파일을 스캔한다
@ComponentScan("controllers")
public class ControllerConfig {
    /*
    @Bean
    public HelloController helloController(){
        return new HelloController();
    }
     */
}
