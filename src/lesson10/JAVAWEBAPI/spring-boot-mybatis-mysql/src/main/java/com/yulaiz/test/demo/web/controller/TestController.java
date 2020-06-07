package com.yulaiz.test.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yulaiz.test.demo.web.param.ClientParam;
import com.yulaiz.test.demo.web.po.Tclazz;
import com.yulaiz.test.demo.web.po.Users;
import com.yulaiz.test.demo.web.service.TestService;
import com.yulaiz.test.demo.web.vo.ClientVo;


//@CrossOrigin("*")
@RestController
public class TestController {



    @Autowired
    private TestService testService;

    //@RequestMapping("/test")
    @RequestMapping(value = "/test" , method = RequestMethod.POST)
    @ResponseBody
    public String test(String name,String pwd) {
        System.out.println(name);
        String value = testService.test(name);
        ClientVo vo = new ClientVo();
        vo.setName(value);
        return "{name:'"+value+"'}";
    }


    //@RequestMapping("/test")
    @RequestMapping(value = "/searchPost" , method = RequestMethod.POST)
    public ClientVo searchPost(@RequestBody ClientParam param) {
        System.out.println(param.getName());
        String value = testService.test(param.getName());
        ClientVo vo = new ClientVo();
        vo.setName(value);
        return vo;
    }

    @RequestMapping(value = "/search" , method = RequestMethod.GET)
    @ResponseBody
    public ClientVo search(String name,String pwd) {
        System.out.println(name);
        String value = testService.test(name);
        ClientVo vo = new ClientVo();
        vo.setName(value);
        return vo;
    }


    @RequestMapping("/insert")
    public String insert(String name,String salary) {
    	try {
    	Users user = new Users();
    	user.setName(name);
    	user.setSalary(salary);
    	Tclazz tcl = new Tclazz();
    	tcl.setName(name);
         testService.insertTable(user,tcl);
         return "OK";
    	} catch(Exception ex) {
    		return "NG";
    	}
    }

    @RequestMapping("/delete")
    public String del(int id) {
    	try {
    	Users user = new Users();
    	user.setId(id);
    	Tclazz tcl = new Tclazz();
    	tcl.setId(id);
         testService.delTable(user,tcl);
         return "OK";
    	} catch(Exception ex) {
    		return "NG";
    	}
    }

    @RequestMapping("/up")
    public String updateData(int id,String name) {
    	try {
    	Users user = new Users();
    	user.setId(id);
    	user.setName(name);
    	Tclazz tcl = new Tclazz();
    	tcl.setId(id);
    	tcl.setName(name);
         testService.upTable(user,tcl);
         return "OK";
    	} catch(Exception ex) {
    		return "NG";
    	}
    }


}
