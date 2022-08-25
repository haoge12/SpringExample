package com.xuhao.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Pointcut("execution(* com.xuhao.service.PhoneService.*(..))")
    public void pt(){
    }
    @Before("pt()")
    public void methodBefore(){
        System.out.println("3");

    }

}
