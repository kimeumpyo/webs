package exam01.main;

import exam01.Greet;
import exam01.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        // get : 객체를 조회하는 메서드
        Greet g1 = ctx.getBean("greet", Greet.class);
        g1.hello("아이유");

        Greet g2 = ctx.getBean("greet", Greet.class);
        g2.hello("야이유");

        System.out.println(g1 == g2);

        ctx.close();
    }
}
