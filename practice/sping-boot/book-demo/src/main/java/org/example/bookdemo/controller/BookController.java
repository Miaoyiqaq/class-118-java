package org.example.bookdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.bookdemo.mapper.BookInfoMapper;
import org.example.bookdemo.model.BookInfo;
import org.example.bookdemo.model.PageRequest;
import org.example.bookdemo.model.PageResponse;
import org.example.bookdemo.server.BookServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired//使用Spring容器中的创建的BookServer对象
    private BookServer bookServer;
    @Autowired
    private BookInfoMapper bookInfoMapper;
    @GetMapping("/getList")
    public List<BookInfo> getList() {
        List<BookInfo> bookInfoList = bookServer.getList();
        return bookInfoList;
    }
    @GetMapping("/getListByPage")
    public PageResponse<BookInfo> getListByPage(PageRequest pageRequest) {
        log.info("pageRequest={}", pageRequest);
        PageResponse<BookInfo> response = bookServer.getListByPage(pageRequest);
        return response;
    }
    @PostMapping("/addBook")
    public String addBook(BookInfo bookInfo) {
        log.info("添加图书:"+ bookInfo.toString());
        System.out.println(bookInfo);
        if(!StringUtils.hasText(bookInfo.getBookName())
        || !StringUtils.hasText(bookInfo.getBookAuthor())
        || bookInfo.getBookCount() == null
        || bookInfo.getBookPrice() == null
        || !StringUtils.hasText(bookInfo.getBookPublish())
        || bookInfo.getBookStatus() == null){
            return "输入参数不合法";
        }
        try {
            bookServer.addBook(bookInfo);
        } catch (Exception e) {
            log.error("添加图书错误!" + e);
        }
        return "";
    }

}
