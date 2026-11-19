package org.example.springtransdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.example.springtransdemo.mapper.LogInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogInfoService {
    @Autowired
    private LogInfoMapper logInfoMapper;
    public void insertLog(String name,String op){
        //记录用户操作​
        logInfoMapper.insertLogInfo(name,"用户注册");
    }
}