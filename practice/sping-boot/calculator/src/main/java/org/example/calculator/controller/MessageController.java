package org.example.calculator.controller;

import org.example.calculator.model.MessageInfo;
import org.example.calculator.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/message")
@RestController
public class MessageController {
//    List<MessageInfo> messageInfoList = new ArrayList<>();
    @Autowired
    private MessageService messageService;
    @GetMapping("/getList")
    public List<MessageInfo> getMessageInfoList() {
        return messageService.getList();
    }
    @PostMapping(value = "/publish", produces = "application/json")
    public String publish(@RequestBody MessageInfo messageInfo) {
        if(!StringUtils.hasText(messageInfo.getMessage())
        || !StringUtils.hasText(messageInfo.getFrom())
        || !StringUtils.hasText(messageInfo.getTo())) {
            return "\"ok\": 0";
        }
        Integer result =messageService.insertMessage(messageInfo);
        if(result == 1) {
            return "\"ok\": 1";
        }
        return "\"ok\": 0";
    }
}
