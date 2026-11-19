package org.example.springtransdemo.controller;

import org.example.springtransdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;//事务管理
    @Autowired
    private TransactionDefinition transactionDefinition;//获取当前事务
    @RequestMapping("/registry")
    public String registry(String name, String password){
        //开启事务
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        //用户注册
        Integer result = userService.registryUser(name,password);
        System.out.println("用户注册成功:" + result);
        //提交事务
//        dataSourceTransactionManager.commit(transactionStatus);
        //回滚事务
        dataSourceTransactionManager.rollback(transactionStatus);

        return "注册成功";
    }
}
