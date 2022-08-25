package com.xuhao.aspect;

import com.xuhao.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class MyAspect {
    @Pointcut("@annotation(com.xuhao.aspect.InvokeLog)")
    public void pt(){
    }
    @Before("pt()")
    public void Before(JoinPoint joinPoint){
        UserService.show();
    }
}
