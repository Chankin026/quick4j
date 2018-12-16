package com.chankin.ssms.core.entity;

/*
 *
 *  用户自定义异常
 * */
public class UserException extends RuntimeException {
    private long date = System.currentTimeMillis();

    public long getDate() {
        return date;
    }
}
