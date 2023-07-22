package exam02.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Order(1)
public class ProxyCache {

    private Map<Long, Object> cache = new HashMap<>();

    @Pointcut("execution(* exam02.aopex..*(..))")
    public void publicTarget() {}

    @Around("publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        Long num = (Long)joinPoint.getArgs()[0];
        if (cache.containsKey(num)) { // 이미 연산된 값이 있으면 연산 X, 반환
            System.out.println("캐시 조회!");
            return cache.get(num);
        }

        Object result = joinPoint.proceed(); // factorial()
        cache.put(num, result);
        System.out.println("캐시 저장!");

        return result;
    }
}
