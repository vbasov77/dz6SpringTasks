package com.example.dz6Tasks.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLoggingAspect {
    @AfterThrowing(pointcut = "@annotation(com.example.dz6Tasks.annotations.LogNotFound)", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        String method = joinPoint.getSignature().toString();
        System.err.println("Ошибка в методе " + method + ":" + ex.getMessage());
    }
}
