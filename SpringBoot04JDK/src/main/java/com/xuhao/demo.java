package com.xuhao;

import com.xuhao.service.UserService;
import com.xuhao.service.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class demo {

    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
//        String s = userServiceImpl.getAnswer("Hello world");
//        System.out.println(s);

        //使用动态代理增强getAnswer()
        // 1、使用JDK动态代理
        //获取类加载器
        ClassLoader c = demo.class.getClassLoader();
        //被代理类所实现接口的字节码对象数组
        Class<?>[] interfaces = userServiceImpl.getClass().getInterfaces();
//        Class<?>[] interfaces = UserServiceImpl.class.getInterfaces();
        UserService proxy = (UserService) Proxy.newProxyInstance(c, interfaces, new InvocationHandler() {
            //使用代理对象的方法时会调用到invoke
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //proxy 是代理对象
                //method 是当前被调用的方法封装的Method对象
                //args 是调用方法时传入的参数
                //调用被代理对象的对应方法
                //判断当前调用的是否是getAnswer方法
                if (method.getName().equals("getAnswer")){
                    System.out.println("增强");
                }
                Object ret = method.invoke(userServiceImpl, args);
                return ret;

            }
        });
        //使用了代理对象的方法，此时会调用invoke方法
        System.out.println(proxy.getName("hello world"));

        System.out.println(proxy.getAnswer("hello"));
        proxy.getHello("444");


        // 此时不能调用getHello方法
//        System.out.println(proxy.getHello("Hello"));
    }
}
