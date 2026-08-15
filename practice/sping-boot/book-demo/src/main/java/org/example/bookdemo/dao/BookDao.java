package org.example.bookdemo.dao;

import org.example.bookdemo.model.BookInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
//@Component//使用Spring容器创建BookDao对象
@Repository
public class BookDao {
    public List<BookInfo> mockBookData() {
        List<BookInfo> bookInfos = new ArrayList<>(15);
        for (int i = 1; i < 15; i++) {
            BookInfo bookInfo = new BookInfo();
            bookInfo.setBookId(i);
            bookInfo.setBookName("图书" + i);
            bookInfo.setBookAuthor("作者" + i);
            bookInfo.setBookCount(i + 1);
            bookInfo.setBookPublish("出版社" + i);
            bookInfo.setBookStatus(i % 3);
            bookInfo.setBookPrice(new BigDecimal(i));
            bookInfos.add(bookInfo);
        }
        return bookInfos;
    }
}
