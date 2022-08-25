package com.xuhao;

import com.xuhao.service.StudentService;
import com.xuhao.service.UserService;
import com.xuhao.utlis.util;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class demo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService student = app.getBean(StudentService.class);
//        util util = app.getBean(util.class);
        String name = util.encode("akey");
        String ret = student.Stu(name);
        System.out.println(ret);
        ClassLoader c1 = demo.class.getClassLoader();
        System.out.println("ClassLoader" + c1);
    }
}
