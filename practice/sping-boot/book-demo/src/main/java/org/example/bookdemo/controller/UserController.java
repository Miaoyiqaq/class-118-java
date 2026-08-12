package org.example.bookdemo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public boolean login(String name, String password) {
        System.out.println("name:" + name);
        System.out.println("password:" + password);
        if(!StringUtils.hasText(name) || !StringUtils.hasText(password)){
            return false;
        }
        //todo 写死
        if("admin".equals(name) && "admin".equals(password)){
            return true;
        }
        return false;
    }

}
