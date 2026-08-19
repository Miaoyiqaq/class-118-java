package org.example.bookdemo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.bookdemo.model.BookInfo;

@Mapper
public interface BookInfoMapper {
    @Insert("insert into book_info (book_name, author, count, price, publish)" +
            "values (#{bookName}, #{bookAuthor}, #{bookCount}, #{bookPrice}, #{bookPublish})")
    Integer addBook(BookInfo bookInfo);
}
