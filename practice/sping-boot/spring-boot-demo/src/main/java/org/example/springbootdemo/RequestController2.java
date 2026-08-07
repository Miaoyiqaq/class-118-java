package org.example.springbootdemo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request2")
public class RequestController2 {
    @RequestMapping("/r1")
    //获取参数,对应RequestController中的r1
    public String r1(String name,HttpServletRequest request){
        String name1 = request.getParameter("name");
        return name1;
    }
    @RequestMapping("/r2")
    //获取重命名参数,对应RequestController中的r1
    public String r2(String na,HttpServletRequest request){
        String name1 = request.getParameter("na");
        return name1;
    }
    @RequestMapping("/getCookie")
    //获取Cookie:传统获取,适用于Cookie数量多的情况
    public String getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for(Cookie cookie : cookies) {
                System.out.println(cookie.getName() + ":" + cookie.getValue());
            }
        }
        return "success";
    }
    @RequestMapping("/getCookie2")
    //获取Cookie2:Spring-boot获取,适用于Cookie数量少的情况
    public String getCookie2(@CookieValue("myName") String name,@CookieValue("age") Integer age) {
        return "myName:"+name+",age:"+age;
    }
    @RequestMapping("/setSession")
    //设置Session
    public String setSession(String name, HttpServletRequest request) {
        //当参数为true时,无session则创建session;当参数为false时,无session也不创建session
        HttpSession session = request.getSession(true);
        //todo 保存浏览器中提交的name为session的value
        if(name == null) {
            name = "testuser";
        }
        session.setAttribute("sessionName", name);
        session.setAttribute("age", 18);
        return "success,用户名为:" + session.getAttribute("sessionName");
    }
    @RequestMapping("/getSession")
    //获取session1:传统获取
    public String getSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session == null) {
            return "未配置session";
        }
        String name = (String)session.getAttribute("sessionName");
        return "sessionName:"+name;
    }
    @RequestMapping("/getSession2")
    //获取session2:直接使用MVC提供的HttpSession类
    public String getSession2(HttpSession session) {
        String name = (String)session.getAttribute("sessionName");
        if(name == null) {
            return "未配置session";
        }
        return "sessionName:"+name;
    }
    @RequestMapping("/getSession3")
    //获取session3:直接使用MVC提供的注解获取SessionName
    public String getSession3(@SessionAttribute("sessionName") String name,
                              @SessionAttribute("age") Integer age) {
        if(name == null) {
            return "未配置session";
        }
        return "sessionName:"+name +",age:"+age;
    }
    @RequestMapping("/getHeader")
    public String getHeader(HttpServletRequest request) {
        String userAgent = request.getHeader("user-Agent");
        return "userAgent:"+userAgent;
    }
    @RequestMapping("/getHeader2")
    public String getHeader2(@RequestHeader("user-Agent") String userAgent) {
        return "userAgent:"+userAgent;
    }


}
