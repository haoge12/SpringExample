package com.xuhao.service;

import com.xuhao.aspect.Invoke;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Invoke
    public String Stu(String name){
        UserService userService = new UserService();
        return userService.show(name);
    }


}
