package com.xuhao.service.impl;

import com.xuhao.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void findById(String id) {
        System.out.println(id);
    }
}
