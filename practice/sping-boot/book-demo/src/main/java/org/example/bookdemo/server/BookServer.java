package org.example.bookdemo.server;

import org.example.bookdemo.mapper.BookInfoMapper;
import org.example.bookdemo.model.BookInfo;
import org.example.bookdemo.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
//使用ioc思想.通过Spring来创建BookServer对象
@Service
public class BookServer {
    @Autowired//从Spring容器中取出BookDao对象
    private BookDao bookDao;
    @Autowired
    private BookInfoMapper bookInfoMapper;
    public List<BookInfo> getList() {
//        BookDao bookDao = new BookDao();
        List<BookInfo> bookInfos = bookDao.mockBookData();
        for (BookInfo bookInfo : bookInfos) {
            if(bookInfo.getBookStatus() == 1) {
                bookInfo.setBookStatusCN("可借阅");
            }else if(bookInfo.getBookStatus() == 2) {
                bookInfo.setBookStatusCN("不可借阅");
            }else{
                bookInfo.setBookStatusCN("无效");

            }
        }
        return bookInfos;
    }

    public void addBook(BookInfo bookInfo) {
        bookInfoMapper.addBook(bookInfo);
    }
}
