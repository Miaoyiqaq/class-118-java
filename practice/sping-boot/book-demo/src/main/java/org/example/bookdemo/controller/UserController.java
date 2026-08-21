package org.example.bookdemo.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.bookdemo.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public boolean login(String name, String password, HttpSession session) {
        log.info("用户登录:" + name);
        if(!StringUtils.hasText(name) || !StringUtils.hasText(password)){
            log.warn("用户名或密码为空");
            return false;
        }
        return  userService.checkPassword(name, password,session);
    }

}
