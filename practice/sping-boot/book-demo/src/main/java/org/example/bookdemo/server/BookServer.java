package org.example.bookdemo.server;

import org.example.bookdemo.model.BookInfo;
import org.example.bookdemo.dao.BookDao;

import java.util.List;

public class BookServer {
    public List<BookInfo> getList() {
        BookDao bookDao = new BookDao();
        List<BookInfo> bookInfos = bookDao.mockBookData();
        for (BookInfo bookInfo : bookInfos) {
            if(bookInfo.getBookStatus() % 3 == 0) {
                bookInfo.setBookStatusCN("可借阅");
            }else {
                bookInfo.setBookStatusCN("不可借阅");
            }
        }
        return bookInfos;
    }
}
