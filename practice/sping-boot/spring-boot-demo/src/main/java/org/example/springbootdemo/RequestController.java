package org.example.springbootdemo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {
    @RequestMapping("/r1")
    //按类型名称接收参数
    public String r1(String name) {
        return "接收到name:" + name;
    }
    @RequestMapping("/r2")
    //同时传递多个参数
    public String r2(String name, String password) {
        return "接收到name:" + name+ '\n' + "接收到password:" + password;
    }
    @RequestMapping("/r3")
    //使用Integer类型时,传递非字符为400(类型转换错误),不传递时封装类型Integer值为null
    public String r2(String name, Integer password) {
        return "接收到name:" + name+ '\n' + "接收到password:" + password;
    }
    @RequestMapping("/r4")
    //使用int类型时,传递传递非字符为400(类型转换错误),不传500(基本类型int无法赋值为null)
    public String r2(String name, int password) {
        return "接收到name:" + name+ '\n' + "接收到password:" + password;
    }
    @RequestMapping("/r5")
    //用类型来接收参数
    public String r5(Person person) {
        return "接收到参数person:" + person;
    }
    @RequestMapping("/r6")
    //前端参数重命名(默认为必须参数,将required字段设置为false可设置为非必须参数)
    public String r6(@RequestParam(value = "wd", required = false)Integer password) {
        return "接收到password:" + password;
    }
    @RequestMapping("/r7")
    //接收集合
    public String r7(String[] arr) {
        return Arrays.toString(arr);
    }
    @RequestMapping("/r8")
    //接收对象不能直接使用对象接收
    public String r8(List<String> list) {
        return list.toString();
    }
    @RequestMapping("/r9")
    //接收对象需要添加注解
    public String r9(@RequestParam List<String> list) {
        return list.toString();
    }
    //接收JSON字符串并转化为对象
    @RequestMapping("/r10")
    public String r10(@RequestBody Person person) {
        return person.toString();
    }
    //从url获取参数
    @RequestMapping("/r11/{value}")
    public String r11(@PathVariable Integer value) {
        return value.toString();
    }
    @RequestMapping("/r11/{value}/{type}")
    public String r11(@PathVariable Integer value, @PathVariable String type) {
        return "vlaue=" + value + '\n' + "type=" + type;
    }
    //
    @RequestMapping("/r12")
    public String r12(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        System.out.println(multipartFile.getOriginalFilename());
        File file = new File("D:/aa/" + multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        return "success" + multipartFile.getOriginalFilename();
    }
}
