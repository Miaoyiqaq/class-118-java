package org.example.stringiocdemo.controller;

import jakarta.annotation.PostConstruct;
import org.example.stringiocdemo.model.DatasourceProperties;
import org.example.stringiocdemo.model.Dbtypes;
import org.example.stringiocdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yaml")
public class YamlController {
    @Autowired
    private Student student;
    @Autowired
    private DatasourceProperties datasourceProperties;
    @Autowired
    private Dbtypes dbtypes;
    @GetMapping("/get")
    @PostConstruct
    public String getStudent() {
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(datasourceProperties);
        System.out.println(dbtypes);
        return "获取成功";
    }

}
