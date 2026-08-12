package org.example.bookdemo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class BookInfo {
    private Integer bookId;
    private String bookName;
    private String bookAuthor;//作者
    private Integer bookCount;//数量
    private BigDecimal bookPrice;
    private String bookPublish;//出版社
    private Integer bookStatus;//状态
    private String bookStatusCN;//状态
}
