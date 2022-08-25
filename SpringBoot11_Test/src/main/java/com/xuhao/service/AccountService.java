package com.xuhao.service;


public interface AccountService {

    void transfer(Integer inId, Integer outId, Double money);
    void log();
}
