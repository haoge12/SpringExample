package com.xuhao.service;

import com.xuhao.aspect.InvokeLog;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {
    @InvokeLog
    public int show(int age, int id, String name) {
//        System.out.println(1/0);
        System.out.println("PhoneService调用了增强");
        return age;
    }
}
