package com.xuhao.service.impl;

import com.xuhao.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestServiceImpl {

    @Autowired
    private AccountService accountService;

    @Transactional
    public void test(){
        accountService.transfer(1,2, 10.0);
        accountService.log();
    }
}
