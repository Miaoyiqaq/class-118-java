package org.example.springbootdemo;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
//返回资源(html)使用Controller
//@RestController = @Controller(返回视图) + @ResponseBody(返回数据)
@RequestMapping("/return")
public class ReturnController {
    @RequestMapping("/re1")
    //返回视图
    public String re1() {
        return "/test.html";
    }
    @ResponseBody
    //返回数据
    @RequestMapping("/re2")
    public String re2() {
        return "/test.html";
    }
    @ResponseBody
    @RequestMapping("/re3")
    public String re3() {
        return "<h1>hello</h1>";
    }
    @ResponseBody
    @RequestMapping("/re4")
    //当返回内容为对象时会自动转化为JSON
    public Person re4(HttpServletResponse response) {
        Person person = new Person();
        person.setId(11);
        person.setAge(22);
        person.setName("咕咕嘎嘎");
        person.setAddress("127.0.0.1");
        response.setStatus(404);
        return person;
    }
    @ResponseBody
    //指定字符串内容为JSON
    @RequestMapping(value = "/re5",produces = "application/json")
    public String re5() {
        return "{\"id\":11,\"name\":\"咕咕嘎嘎\",\"age\":22,\"address\":\"127.0.0.1\"}";
    }
    @ResponseBody
    @RequestMapping(value = "/re6")
    //自定义响应头
    public String re6(HttpServletResponse response) {
        response.setHeader("MyHeader","MyValue");
        return "success";
    }
}
