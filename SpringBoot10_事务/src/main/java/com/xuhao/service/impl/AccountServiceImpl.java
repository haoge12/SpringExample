package com.xuhao.service.impl;

import com.xuhao.dao.AccountDao;
import com.xuhao.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Override
    public void transfer(Integer inId, Integer outId, Double money) {
        accountDao.upDate(inId, money);
        accountDao.upDate(outId, -money);
    }
}
