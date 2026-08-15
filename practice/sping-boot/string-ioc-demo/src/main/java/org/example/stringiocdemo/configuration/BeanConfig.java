package org.example.stringiocdemo.configuration;

import org.example.stringiocdemo.model.UserInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public UserInfo userInfo() {
        UserInfo userInfo = new UserInfo(1,"aaa");
        return userInfo;
    }
    @Bean
    public UserInfo userInfo1() {
        UserInfo userInfo = new UserInfo(2,"bbb");
        return userInfo;
    }
}
