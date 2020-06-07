package com.yulaiz.test.demo.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yulaiz.test.demo.web.dao.TestMapper;
import com.yulaiz.test.demo.web.po.Tclazz;
import com.yulaiz.test.demo.web.po.Users;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class TestService {

    @Autowired
    private TestMapper testMapper;


    public String test(String name){
        log.info(name + testMapper.getTest());
        String sp = testMapper.getTest();
        return name + sp;
    }

    @Transactional
    public void insertTable(Users user ,Tclazz tcl ) {
    	testMapper.insertClass(tcl);
    	testMapper.insertUsers(user);
    }

    @Transactional
    public void delTable(Users user ,Tclazz tcl ) {
    	testMapper.delClass(tcl);
    	testMapper.delUsers(user);
    }


    @Transactional
    public void  upTable(Users user ,Tclazz tcl ) {
    	testMapper.upClass(tcl);
    	testMapper.upUsers(user);
    }

}
