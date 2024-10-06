package com.spring.transactional_proxy_research.transactional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CallTracker {

    @Pointcut("within(com.spring.transactional_proxy_research.transactional.*)")
    public void logMethodPointCut() {

    }

    @Around("logMethodPointCut()")
    public Object logBeforeMethodCall(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Starting " + pjp.getSignature().getName());
        Object returnValue = pjp.proceed();
        System.out.println("Completed " + pjp.getSignature().getName());
        return returnValue;
    }
}
