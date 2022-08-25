package com.xuhao.aspect;

import com.xuhao.service.UserService;
import com.xuhao.utlis.util;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
    @Pointcut("@annotation(com.xuhao.aspect.Invoke)")
    public void pt(){
    }

    @Around("pt()")
    public Object Around(ProceedingJoinPoint proceedingJoinPoint){
        Object[] args = proceedingJoinPoint.getArgs();  // 获取参数
        // 解密
        Object arg = args[0];
        String decode = util.decode((String) arg);
        args[0] = decode;
        String ret = null;
//        System.out.println("args"+ args[0]);
        try {
            Object proceed = proceedingJoinPoint.proceed(args);// 执行方法
//            System.out.println("pr" + proceed);
            ret = (String) proceed;
//            ret = util.encode(ret);
        } catch (Throwable e) {
            e.printStackTrace();
        }
//        System.out.println("ret" + ret);
        return ret;
    }
}
