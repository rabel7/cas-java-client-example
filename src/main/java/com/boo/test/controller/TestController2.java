package com.boo.test.controller;

import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController2 {

    /**
     * 不能包含{}
     * @return
     */
    @RequestMapping("/test2")
    public String test1kString(HttpServletRequest request) {


        return "index.jsp";
    }

}
