package exam02.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
@Order(2)
public class ProxyCalculator {

    @Pointcut("execution(* exam02.aopex..*(..))")
    //@Pointcut("execution(long exam02.aopex..*.factorial(long))")
    public void publicTarget() {}

    @Around("publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        long stime = System.nanoTime();
        try {

             Object target = joinPoint.getTarget();
             System.out.println("target : " + target); // 호출한 객체

            Signature sig = joinPoint.getSignature();
            System.out.println("Signature : " + sig.toLongString()); // 호출된 메서드

            Object[] args = joinPoint.getArgs(); // 사용된 매개변수의 정보

            System.out.println(Arrays.toString(args));

            Object result = joinPoint.proceed(); // 핵심 기능  - factorial();

            return result;

        } finally {
            long etime = System.nanoTime();
            System.out.println("걸린 시간 : " + (etime - stime));
        }
    }
}
