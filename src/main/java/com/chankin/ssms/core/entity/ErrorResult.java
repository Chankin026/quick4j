package com.chankin.ssms.core.entity;

import java.util.HashMap;
import java.util.Map;

public class ErrorResult extends Result {
    //封装多个错误信息
    private Map<String, Object> errors = new HashMap<>();

    public Map<String, Object> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, Object> errors) {
        this.errors = errors;
    }

    public ErrorResult() {

    }
}
