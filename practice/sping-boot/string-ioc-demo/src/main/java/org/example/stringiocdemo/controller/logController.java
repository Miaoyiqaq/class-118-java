package org.example.stringiocdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/log")
public class logController {

//    private static Logger logger = LoggerFactory.getLogger(logController.class);
    @RequestMapping("/print")
    public void print() {
        log.trace("trace");
        log.debug("debug");
        log.info("打印日志");
        log.error("打印日志");
    }
}
