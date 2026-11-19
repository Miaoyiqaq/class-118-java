package com.example.springblogdemo.common.util;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class SecurityUtils {
    /***
     * 对原始密码进行加密
     * @param password 用户输入的原始密码
     * @return 加密后的密码
     */
    public static String encrypt(String password) {
        //盐
        String salt = UUID.randomUUID().toString().replace("-","");
        //生成好的密文(密码加盐)
        String encryptPassword = DigestUtils.md5DigestAsHex((password + salt).getBytes(StandardCharsets.UTF_8));
        //数据库存储的密码(密文加盐)
        return encryptPassword + salt;
    }

    /***
     * 验证密码
     * @param inputPassword 用户输入的密码
     * @param dbPassword 数据库中的密码
     * @return 验证结果
     */
    public static boolean verify(String inputPassword, String dbPassword) {
        if(dbPassword.length() != 64 || inputPassword == null) {
            return false;
        }
        String salt = dbPassword.substring(32,64);
        String encryptInputPassword = DigestUtils.md5DigestAsHex((inputPassword + salt).getBytes(StandardCharsets.UTF_8));
        return dbPassword.equals(encryptInputPassword + salt);
    }
}
