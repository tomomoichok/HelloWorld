package com.yulaiz.test.demo.web.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.yulaiz.test.demo.web.po.Tclazz;
import com.yulaiz.test.demo.web.po.Users;

@Mapper
@Repository
public interface TestMapper {

    String getTest();

    void insertUsers(Users user);
    void insertClass(Tclazz tcl);

    void delUsers(Users user);
    void delClass(Tclazz tcl);


    void upUsers(Users user);
    void upClass(Tclazz tcl);

}
