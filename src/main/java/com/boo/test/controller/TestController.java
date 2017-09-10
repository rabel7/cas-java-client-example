package com.boo.test.controller;

import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    /**
     * 不能包含{}
     * @return
     */
    @RequestMapping("/test")
    public String test1kString(HttpServletRequest request) {


        Assertion assertion = AssertionHolder.getAssertion();
        String userName = assertion.getPrincipal().getName();
        System.out.println(assertion.getPrincipal().getAttributes());
        return userName;
    }

}
