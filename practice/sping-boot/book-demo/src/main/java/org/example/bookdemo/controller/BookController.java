package org.example.bookdemo.controller;

import org.example.bookdemo.model.BookInfo;
import org.example.bookdemo.server.BookServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @GetMapping("/getList")
    public List<BookInfo> getList() {
        BookServer bookServer = new BookServer();
        List<BookInfo> bookInfoList = bookServer.getList();
        return bookInfoList;
    }

}
