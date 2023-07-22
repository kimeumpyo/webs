package exam02.main;

import exam02.aopex.Calculator;
import exam02.aopex.RecCalculator;
import exam02.config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        Calculator cal = ctx.getBean(RecCalculator.class); // 오류발생! => 추가 : @EnableAspectJAutoProxy(proxyTargetClass = true)
        //Calculator cal = ctx.getBean(Calculator.class);

        long result = cal.factorial(10);
        System.out.println(result);

        ctx.close();
    }
}
