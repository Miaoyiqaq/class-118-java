package org.example.calculator.service;

import org.example.calculator.mapper.MessageMapper;
import org.example.calculator.mapper.MessageMapperXML;
import org.example.calculator.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private MessageMapperXML messageMapperXML;
    public List<MessageInfo> getList() {
        return messageMapper.selectList();
    }

    public Integer insertMessage(MessageInfo messageInfo) {
        return messageMapper.insertMessage(messageInfo);
    }
}
