package exam02.config;

import exam02.aopex.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@EnableAspectJAutoProxy
@EnableAspectJAutoProxy(proxyTargetClass = true) // 클래스 기반의 프록시 생성
public class AppCtx {

    @Bean
    public ProxyCache proxyCache() {
        return new ProxyCache();
    }

    @Bean
    public ProxyCalculator proxyCalculator() {
        return new ProxyCalculator();
    }

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }
}
