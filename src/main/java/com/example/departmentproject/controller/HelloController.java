package com.example.departmentproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/getMapping", method = RequestMethod.GET)
    public String hello() {
        return  "Let go get em come here another addition";
    }
}
