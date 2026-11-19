package org.example.springaopdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.springaopdemo.aspect.MyAspect;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @MyAspect
    @RequestMapping("/t1")
    public String t1() {
        log.info("t1 running");
        return "t1";
    }
    @RequestMapping("/t2")
    public Integer t2() {
        log.info("t2 running");
//        int a = 10/0;
        return 10;
    }
    @MyAspect
    @RequestMapping("/t3")
    public boolean t3() {
        log.info("t3 running");
        return true;
    }
}
