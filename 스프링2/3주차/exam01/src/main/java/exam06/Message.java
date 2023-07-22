package exam06;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.sql.SQLOutput;

public class Message implements InitializingBean, DisposableBean {
    public void send(String message){
        System.out.println("전송 : "+message);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 객체 생성 -> 의존성 해결 -> 초기화(호출)
        System.out.println("afterPropertiesSet()!");
    }

    @Override
    public void destroy() throws Exception {
    // 객체 생성 -> 의존성 해결 -> 초기화(afterPropertiesSet 호출) -> 소멸(destroy() -> 소멸)
        System.out.println("destroy!");
    }



}
