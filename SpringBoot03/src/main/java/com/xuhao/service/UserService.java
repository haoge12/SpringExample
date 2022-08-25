package com.xuhao.service;


import com.xuhao.aspect.Invoke;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Invoke
    public String show(String name){
        return name;
    }
}
