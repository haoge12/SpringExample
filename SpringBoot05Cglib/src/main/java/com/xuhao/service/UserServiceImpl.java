package com.xuhao.service;

public class UserServiceImpl implements UserService{
    @Override
    public String getName(String name) {
        return "你好，" + name;
    }

    @Override
    public String getAnswer(String question) {
        return question + ", Yes";
    }

    @Override
    public String getHello(String hello){
        return hello + ", world";
    }
}
