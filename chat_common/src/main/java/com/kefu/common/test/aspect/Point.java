package com.kefu.common.test.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
@Aspect
@Component
@Slf4j
public class Point {
    @Pointcut("@annotation(com.kefu.common.test.aspect.LogAnnotation)")
    public void pt(){

    }
    @Before("pt()")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("Method called: " + joinPoint.getSignature().getName());
    }
    @After("pt()")
    public void afterMethod(JoinPoint joinPoint){
        System.out.println("Method execution completed: " + joinPoint.getSignature().getName());
    }

}
