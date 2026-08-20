package org.example.bookdemo.mapper;

import jdk.jfr.StackTrace;
import org.apache.ibatis.annotations.*;
import org.example.bookdemo.model.BookInfo;
import org.example.bookdemo.model.PageRequest;

import java.util.List;

@Mapper
public interface BookInfoMapper {

    @Insert("insert into book_info (book_name, author, count, price, publish)" +
            "values (#{bookName}, #{bookAuthor}, #{bookCount}, #{bookPrice}, #{bookPublish})")
    Integer addBook(BookInfo bookInfo);

    @Select("select count(1) from book_info where status<>0")
    Integer count();

    @Results(id = "bookInfoMap", value = {
            @Result(column = "id", property = "bookId"),
            @Result(column = "book_name", property = "bookName"),
            @Result(column = "author", property = "bookAuthor"),
            @Result(column = "count", property = "bookCount"),
            @Result(column = "price", property = "bookPrice"),
            @Result(column = "publish", property = "bookPublish"),
            @Result(column = "status", property = "bookStatus"),
            @Result(column = "create_time", property = "bookCreateTime"),
            @Result(column = "update_time", property = "bookUpdateTime")
    })
    @Select("select * from book_info where status<>0 limit #{offset}, #{pageSize}")
    List<BookInfo> getListByPage(PageRequest pageRequest);
}
