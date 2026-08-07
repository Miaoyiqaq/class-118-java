package org.example.springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController//类注解:有了这个才会搜索到下面的RequestMapping注解
@RequestMapping("/hello")//方法注解:参数即为路径
public class HelloController {
    @RequestMapping(value = "/v1", method = RequestMethod.GET)
    public String hello() {
        return "Hello,Spring Boot";
    }
    @RequestMapping("/v2")
    public Integer getNum() {
        return 12312;
    }
    @GetMapping("/v3")
    public String v3() {
        return "v3";
    }
}
