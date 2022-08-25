package com.xuhao.service;

import com.xuhao.aspect.InvokeLog;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @InvokeLog
    public static void show() {
        System.out.println("UserService中的show");
    }
}
