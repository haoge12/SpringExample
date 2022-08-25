package com.xuhao;

import com.xuhao.service.AccountService;
import com.xuhao.service.impl.TestServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class test {
    @Autowired
    private AccountService accountService;

    @Autowired
    private TestServiceImpl testService;
    @Test
    public void testAccount(){
        accountService.transfer(1,2, 10.0);
    }

    @Test
    public void test1(){
        testService.test();

    }
}
