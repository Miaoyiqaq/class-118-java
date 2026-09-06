package org.example.bookdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/t1")
    public boolean t1() {
        int a = 1/0;
        return true;
    }
    @GetMapping("/t2")
    public int t2() {
        int[] a = new int[4];
        System.out.println(a[4]);
        return 10;
    }
    @GetMapping("/t3")
    public String t3() {
        String a = null;
        System.out.println(a.length());
        return "t3";
    }
}
