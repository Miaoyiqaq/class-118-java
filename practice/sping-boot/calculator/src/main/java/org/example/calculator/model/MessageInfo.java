package org.example.calculator.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
public class MessageInfo {
    private Integer id;
    private String from;
    private String to;
    private String message;
    private String deleteFlag;
    private Date createTime;
    private Date updateTime;
//    public MessageInfo() {}
}
