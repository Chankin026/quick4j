package com.chankin.ssms.core.entity;

public class JSONResult<T> extends Result {
    private static final long serialVersionUID = 4533453453434535435L;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T date) {
        this.data = date;
    }

    public JSONResult() {
        super();
    }

    public JSONResult(T data, String message, boolean success) {
        this.data = data;
        super.setMessage(message);
        super.setSuccess(success);
    }

    public JSONResult(T data, String message) {
        this.data = data;
        super.setMessage(message);
        super.setSuccess(true);
    }

    public JSONResult(T data) {
        this.data = data;
        super.setSuccess(true);
    }
}
