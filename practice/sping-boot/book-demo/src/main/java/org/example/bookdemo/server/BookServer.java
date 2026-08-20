package org.example.bookdemo.server;

import org.example.bookdemo.mapper.BookInfoMapper;
import org.example.bookdemo.model.BookInfo;
import org.example.bookdemo.dao.BookDao;
import org.example.bookdemo.model.PageRequest;
import org.example.bookdemo.model.PageResponse;
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
            setStatus(bookInfo);
        }
        return bookInfos;
    }
    private void setStatus(BookInfo bookInfo) {
        if (bookInfo.getBookStatus() == 1) {
            bookInfo.setBookStatusCN("可借阅");
        } else if (bookInfo.getBookStatus() == 2) {
            bookInfo.setBookStatusCN("不可借阅");
        } else {
            bookInfo.setBookStatusCN("无效");
        }
    }

    public void addBook(BookInfo bookInfo) {
        bookInfoMapper.addBook(bookInfo);
    }

    public PageResponse<BookInfo> getListByPage(PageRequest pageRequest) {
        Integer count = bookInfoMapper.count();
        if (count == 0) {
            return new PageResponse<>(count, null);
        }
        List<BookInfo> bookInfos = bookInfoMapper.getListByPage(pageRequest);
        if(bookInfos==null||bookInfos.size()==0){
            return new PageResponse<>(count, bookInfos);
        }
        for(BookInfo bookInfo : bookInfos) {
            setStatus(bookInfo);
        }
        return new PageResponse<>(count, bookInfos);
    }
}
