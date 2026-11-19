package org.example.springtransdemo.controller;

import org.example.springtransdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/trans")
@RestController
public class TransController {
    @Autowired
    private UserService userService;

    @Transactional
    @RequestMapping("/registry")
    public String registry(String name, String password) {
        Integer result = userService.registryUser(name, password);
        System.out.println("用户注册成功:" + result);

        return "注册成功";
    }
}
