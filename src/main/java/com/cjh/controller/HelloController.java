package com.cjh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: chenJianHui
 * @date: 2021/11/15 15:52
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String showHello() {
        return "Hello world  !!!";
    }

    @RequestMapping("/test")
    public String showTest() {
        return "Test";
    }
}
