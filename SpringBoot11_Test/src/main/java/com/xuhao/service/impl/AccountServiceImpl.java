package com.xuhao.service.impl;

import com.xuhao.dao.AccountDao;
import com.xuhao.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;


    @Override
    @Transactional
    public void transfer(Integer inId, Integer outId, Double money) {
        // 增加
        accountDao.updateMoney(inId, money);
//        System.out.println(1/0);
        //减少
        accountDao.updateMoney(outId, -money);
    }

    @Override
    @Transactional
    public void log() {
        System.out.println("打印日志");
        System.out.println(1/0);
    }


}
