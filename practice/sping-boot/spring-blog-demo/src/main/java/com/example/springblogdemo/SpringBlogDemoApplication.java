package com.example.springblogdemo;

import com.example.springblogdemo.common.util.SecurityUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.example.springblogdemo.mapper")
@SpringBootApplication
public class SpringBlogDemoApplication {

    public static void main(String[] args) {
//        System.out.println(SecurityUtils.encrypt("123456"));
//        System.out.println(SecurityUtils.verify("123356",SecurityUtils.encrypt("123456")));
        SpringApplication.run(SpringBlogDemoApplication.class, args);
    }

}
