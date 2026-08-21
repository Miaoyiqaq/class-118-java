package org.example.bookdemo.server;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.bookdemo.mapper.UserInfoMapper;
import org.example.bookdemo.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    public boolean checkPassword(String name, String password, HttpSession session) {
        UserInfo userInfo = userInfoMapper.queryUserInfoByName(name);
        if (userInfo == null || userInfo.getUserId() < 1) {
            log.warn("用户不存在:" + name);
            return false;
        }
        if(password.equals(userInfo.getUserPassword())) {
            log.info("用户:" + name + "密码正确:" + password);
            session.setAttribute("userId", userInfo.getUserId());
            session.setAttribute("userName", userInfo.getUserName());
            return true;
        }
        log.info("用户:" + name + "密码错误:" + password);
        return false;
    }
}
