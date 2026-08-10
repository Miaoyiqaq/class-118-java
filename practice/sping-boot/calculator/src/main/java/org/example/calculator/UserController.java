package org.example.calculator;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session) {
//        if(userName == null || password == null || "".equals(userName) || "".equals(password)) {
//            return false;
//        }
        if(!StringUtils.hasText(userName) || !StringUtils.hasText(password)) {
            return false;
        }
        //todo 暂时写死
        if("admin".equals(userName) && "123456".equals(password)) {
            session.setAttribute("userSession", userName);
            return true;
        }
        return false;
    }
    @GetMapping("/getLoginUser")
    public String getLoginUser(HttpSession session) {

        return session.getAttribute("userSession").toString();
    }
}
