package com.kefu.util;

import lombok.Data;

@Data
public class R {
    private int code;

    private String message;

    private String type;

    private Boolean success;

    private Object data;

    public static R ok() {
        R r = new R();
        r.setCode(200);
        r.setSuccess(true);
        r.setType("success");
        r.setData(null);
        return r;
    }
    public static R success(String message) {
        R r = new R();
        r.setCode(200);
        r.setMessage(message);
        r.setSuccess(true);
        r.setType("success");
        r.setData(null);
        return r;
    }

    public static R success(String message, Object data) {
        R r = success(message);
        r.setCode(200);
        r.setSuccess(true);
        r.setType("success");
        r.setData(data);
        return r;
    }
    public static R success(Object data) {
        R r = new R();
        r.setCode(200);
        r.setMessage("请求成功");
        r.setSuccess(true);
        r.setType("success");
        r.setData(data);
        return r;
    }
    public static R warning(String message) {
        R r = error(message);
        r.setType("warning");
        return r;
    }

    public static R error(String message) {
        R r = new R();
        r.setCode(400);
        r.setMessage(message);
        r.setSuccess(false);
        r.setType("error");
        return r;
    }

    public static R fatal(String message) {
        R r = error(message);
        r.setCode(500);
        return r;
    }
    public static R error(Object data){
        R r = ok();
        r.setSuccess(false);
        r.setData(data);
        r.setType("error");
        return r;
    }
}
