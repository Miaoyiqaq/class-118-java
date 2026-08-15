package org.example.stringiocdemo;

import org.example.stringiocdemo.controllerTest.Controller;
import org.example.stringiocdemo.model.UserInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StringIocDemoApplication {

    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(StringIocDemoApplication.class, args);
////        Controller bean = context.getBean(Controller.class);
////        bean.print();
//        UserInfo bean = context.getBean("userInfo", UserInfo.class);
//        UserInfo bean1 = (UserInfo) context.getBean("userInfo1");
//        System.out.println(bean);
//        System.out.println(bean1);
//    }
        SpringApplication.run(StringIocDemoApplication.class, args);
    }
}
