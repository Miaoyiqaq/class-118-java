package org.example.bookdemo.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.bookdemo.mapper.BookInfoMapper;
import org.example.bookdemo.model.*;
import org.example.bookdemo.server.BookServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired//使用Spring容器中的创建的BookServer对象
    private BookServer bookServer;
    @Autowired
    private BookInfoMapper bookInfoMapper;

    @GetMapping("/getListByPage")
    public Result<PageResponse<BookInfo>> getListByPage(PageRequest pageRequest, HttpSession session) {
        if(session.getAttribute("userName") == null){
            log.info("用户未登录");
            return Result.unLogin();
        }
        log.info("pageRequest={}", pageRequest);
        PageResponse<BookInfo> response = bookServer.getListByPage(pageRequest);
        return Result.success(response);
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

    @GetMapping("/queryBookById")
    public BookInfo queryBookById(Integer bookId) {
        log.info("查询图书id:" + bookId);
        BookInfo bookInfo = bookServer.queryBookById(bookId);
        log.info(bookInfo.toString());
        return bookInfo;
    }

    @PostMapping("/updateBook")
    public String updateBook(BookInfo bookInfo) {
        log.info("更新图书:"+ bookInfo);
        try {
            Integer result = bookServer.updateBook(bookInfo);
            return result==1?"":"图书更新失败";
        }catch (Exception e) {
            log.error("图书更新失败,e",e);
            return "图书更新失败";
        }
    }

    @PostMapping("/deleteBook")
    public String deleteBook(Integer bookId) {
        log.info("删除图书:" + bookId);
        try {
            Integer result = bookServer.deleteBook(bookId);
            return result==1?"":"图书删除失败";
        }catch (Exception e) {
            log.error("图书删除失败,e",e);
            return "图书删除失败";
        }
    }

    @PostMapping("/batchDeleteBook")
    public String batchDeleteBook(@RequestParam List<Integer> bookIds) {
        log.info("批量删除:" + bookIds);
        try {
            bookServer.batchDelete(bookIds);
            return "";
        } catch (Exception e) {
            log.error("批量删除失败,e" + e);
            return "批量删除失败";
        }
    }

}
