package com.example.aop;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.example.annotation.Retry;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class RetryAop {

    private final Log log = LogFactory.get();

    @Around(value = "@annotation(com.example.annotation.Retry)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = null;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        Method method = signature.getMethod();
        if (method.isAnnotationPresent(Retry.class)) {
            Retry retry = method.getAnnotation(Retry.class);
            int attempt = 0;
            int maxAttempt = retry.maxAttempt();
            int interval = retry.interval();
            while (attempt <= maxAttempt) {
                try {
                    proceed = joinPoint.proceed();
                    return proceed;
                } catch (Throwable e) {
                    attempt++;
                    if (attempt > maxAttempt) {
                        throw new RuntimeException(e.getCause());
                    }
                    log.error(methodName + " 方法发生异常，将会在 " + interval + " ms后进行重试，当前重试 " + attempt + " 次，最大 " + maxAttempt + " 次");
                    Thread.sleep(interval);
                }
            }
        }
        return null;
    }
}
