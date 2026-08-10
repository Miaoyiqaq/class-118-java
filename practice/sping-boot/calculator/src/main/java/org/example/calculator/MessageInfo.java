package org.example.calculator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageInfo {
    private String from;
    private String to;
    private String message;
    public MessageInfo() {}
}
