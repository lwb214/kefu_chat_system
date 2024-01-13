package com.kefu.util;

import lombok.Data;

/**
 * @ProjectName:
 * @Package: com.kefu.util
 * @ClassName: Result
 * @Author: 路文斌
 * @description: 封装分会数据
 * @date:
 * @version: 1.0
 */
@Data
public class Result<T> {

    private String code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public static Result success() {
        Result result = new Result();
        result.setCode("200");
        result.setMsg("成功");
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result(data);
        result.setCode("200");
        result.setMsg("成功~~~");
        return result;
    }

    public static <T> Result<T> success(String code, String msg, T data) {
        Result<T> result = new Result(data);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static Result error(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}