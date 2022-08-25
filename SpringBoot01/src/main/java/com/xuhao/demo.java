package com.xuhao;

import com.xuhao.service.PhoneService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        PhoneService phoneService = app.getBean(PhoneService.class);
        phoneService.show();
//        PhoneService ps = new PhoneService();
//        ps.show();

    }
}
