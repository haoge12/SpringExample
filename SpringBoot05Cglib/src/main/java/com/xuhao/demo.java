package com.xuhao;

import com.xuhao.service.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class demo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //设置父类的字节码对象
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            //使用代理对象执行方法时都会调用到intercept方法
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                // 调用父类中对应的方法
//                if(method.getName().equals("getAnswer")){
//                    System.out.println("增强");
//                }
                System.out.println("增强");
                Object ret = methodProxy.invokeSuper(o, objects);
                return ret;
            }
        });
        //生成代理对象
        UserServiceImpl proxy = (UserServiceImpl) enhancer.create();
        //使用了代理对象的方法，此时会执行intercept方法
        System.out.println(proxy.getAnswer("hello world"));
        System.out.println(proxy.getName("xuhao"));
        System.out.println(proxy.getHello("hello"));
    }
}
