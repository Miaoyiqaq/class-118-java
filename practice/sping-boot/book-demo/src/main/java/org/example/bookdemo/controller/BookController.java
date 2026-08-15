package org.example.bookdemo.controller;

import org.example.bookdemo.model.BookInfo;
import org.example.bookdemo.server.BookServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired//使用Spring容器中的创建的BookServer对象
    private BookServer bookServer;
    @GetMapping("/getList")
    public List<BookInfo> getList() {
        List<BookInfo> bookInfoList = bookServer.getList();
        return bookInfoList;
    }

}
