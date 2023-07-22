package exam06.main;

import exam06.Message;
import exam06.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

//        Message message = ctx.getBean("message", Message.class);
        Message message = ctx.getBean(Message.class);
        message.send("안녕하세요!");

        ctx.close(); // 소멸 (destroy() -> 소멸)
    }
}
