package com.yulaiz.test.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yulaiz.test.demo.web.service.TestService;
import com.yulaiz.test.demo.web.vo.ClientVo;


@RestController
@RequestMapping("/jsonp")
public class TestControllerJsonp {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/searchJsonp", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ClientVo searchJsonp(String name,String pwd) {
        System.out.println(name);
        String value = testService.test(name);
        ClientVo vo = new ClientVo();
        vo.setName(value);
        return vo;
    }

}
