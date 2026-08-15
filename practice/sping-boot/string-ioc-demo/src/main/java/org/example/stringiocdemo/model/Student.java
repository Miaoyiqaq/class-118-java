package org.example.stringiocdemo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration

@ConfigurationProperties(prefix = "student")
@Data
public class Student {
    private int id;
    private String name;
    private int age;
}
