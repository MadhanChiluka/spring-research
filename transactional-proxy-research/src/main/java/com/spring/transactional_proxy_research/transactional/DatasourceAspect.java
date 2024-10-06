package com.spring.transactional_proxy_research.transactional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.engine.jdbc.connections.internal.ConnectionCreatorFactoryImpl;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.Connection;


@Aspect
@Component
public class DatasourceAspect {

    @Around("target(javax.sql.DataSource)")
    public Object logDataSouceConnectionInfo(ProceedingJoinPoint pjp) throws Throwable {
        String name = pjp.getSignature().toLongString();
        System.out.println("Started " + name);
        Object returnValue = pjp.proceed();
        if(returnValue.getClass().getClassLoader() != null) {
            Proxy.newProxyInstance(
                    returnValue.getClass().getClassLoader(), new Class[] {Connection.class}, new ConnectionInvocationHandler((Connection) returnValue));
        }
        return returnValue;
    }
}
