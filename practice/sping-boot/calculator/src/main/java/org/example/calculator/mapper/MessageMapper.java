package org.example.calculator.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.calculator.model.MessageInfo;

import java.util.List;

@Mapper
public interface MessageMapper {
    @Select("select * from message_info where delete_flag = 0")
     List<MessageInfo> selectList();

    @Insert("insert into message_info (`from`, `to`, message`) values (#{from}, #{to}, #{message})")
    Integer insertMessage(MessageInfo messageInfo);
}
