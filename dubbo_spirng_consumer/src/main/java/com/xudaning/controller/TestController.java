package com.xudaning.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xudaning.domain.User;
import com.xudaning.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Reference
    private TestService testService;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("开始调动dubbo服务");
        return testService.sayHello("Hello springboot and dubbo!");
    }

    @GetMapping("/user")
    public User user() {
        return testService.findUser();
    }
}
