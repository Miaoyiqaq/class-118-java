package org.example.calculator;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/message")
@RestController
public class MessageController {
    List<MessageInfo> messageInfoList = new ArrayList<>();
    @GetMapping("/getList")
    public List<MessageInfo> getMessageInfoList() {
        return messageInfoList;
    }
    @PostMapping(value = "/publish", produces = "application/json")
    public String publish(@RequestBody MessageInfo messageInfo) {
        if(!StringUtils.hasText(messageInfo.getMessage())
        || !StringUtils.hasText(messageInfo.getFrom())
        || !StringUtils.hasText(messageInfo.getTo())) {
            return "\"ok\": 0";
        }
        messageInfoList.add(messageInfo);
        return "\"ok\": 1";
    }
}
