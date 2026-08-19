package org.example.calculator.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.calculator.model.MessageInfo;

import java.util.List;

@Mapper
public interface MessageMapperXML {
    List<MessageInfo> selectList();
    Integer insertMessage(MessageInfo messageInfo);

}
