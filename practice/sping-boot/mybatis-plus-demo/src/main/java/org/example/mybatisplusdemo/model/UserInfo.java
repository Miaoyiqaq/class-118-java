package org.example.mybatisplusdemo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
//数据库表名映射
@TableName("user_info")
public class UserInfo {
    //约定主键自增
    @TableId(type = IdType.AUTO)
    private Integer id;
    //数据库列映射
    @TableField("username")
    private String username;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}