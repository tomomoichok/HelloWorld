package com.yulaiz.test.demo.web.jsonp;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;


@ControllerAdvice(basePackages = "com.yulaiz.test.demo.web.controller")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice{

    public JsonpAdvice() {
    	super("callback","jsonp");

//        super("callback");
    }
}