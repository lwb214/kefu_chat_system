package com.kefu.util;

import com.kefu.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data){
        ResultEnum success = ResultEnum.SUCCESS;
        return new Result<T>(success.getCode(),success.getMsg(),data);
    }

    public static <T> Result<T> fail(ResultEnum param){
        return new Result<T>(param.getCode(),param.getMsg(),null);
    }
    public static <T> Result<T> fail(T data){
        ResultEnum fail = ResultEnum.FAIL;
        return new Result<T>(fail.getCode(),fail.getMsg(),data);
    }
}