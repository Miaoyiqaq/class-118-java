package com.example.springblogdemo.common.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecurityUtilsTest {

    @Test
    void encrypt(String password) {
        String encryptedPassword = SecurityUtils.encrypt("password");
        System.out.println(encryptedPassword);
    }

    @Test
    void verify() {
    }
}