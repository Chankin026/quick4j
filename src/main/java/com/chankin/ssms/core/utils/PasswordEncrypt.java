package com.chankin.ssms.core.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import java.util.UUID;


public class PasswordEncrypt {
    //用户密码md5加密
    public static String createHash(String username, String password) {
        Object object = new SimpleHash(
                "MD5",
                password,
                ByteSource.Util.bytes(username)
                , 1024);
        return object.toString();
    }

    //产生36个字符的uuid
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    //md5加密
    public static String md5Hex(String value) {
        return DigestUtils.md5Hex(value);
    }

    //sha1加密
    public static String sha1Hex(String value) {
        return DigestUtils.sha1Hex(value);
    }

    //sha256加密
    public static String sha256Hex(String value) {
        return DigestUtils.sha256Hex(value);
    }

}
