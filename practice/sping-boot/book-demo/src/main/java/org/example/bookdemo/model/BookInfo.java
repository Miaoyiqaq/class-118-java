package org.example.bookdemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class BookInfo {
    private Integer bookId;
    private String bookName;
    private String bookAuthor;//作者
    private Integer bookCount;//数量
    private BigDecimal bookPrice;
    private String bookPublish;//出版社
    private Integer bookStatus;//状态
    private String bookStatusCN;//状态
    private Date bookUpdateTime;
    private Date bookCreateTime;
}
