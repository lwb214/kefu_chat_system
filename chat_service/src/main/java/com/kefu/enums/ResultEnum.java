package com.kefu.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(200, "请求成功"),
    FAIL(911, "请求失败"),
    PARAMS_MISS(1001,"缺少必要参数"),
    EMPTY(1002, "参数不可为空值"),
    SIZE_EXCEED_LIMIT(1003, "长度超过限制"),
    PASSWORD_SIZE_SMALL(1004, "密码长度太小"),
    PARAMS_MISTAKE(1005, "账号或密码错误"),
    TOKEN_EXPIRED(1006, "TOKEN已过期"),
    TOKEN_ILLEGAL(1007, "TOKEN不合法"),
    NO_LOGIN(1008, "未登录"),
    ACCOUNT_NOT_EXIST(1009, "账号不存在"),
    PARAMS_CHECK_SUCCESS(1010, "参数前置校验通过"),
    ACCOUNT_EXIST(1011, "账号已被注册"),
    REGISTER_FAIL(1012,"注册失败"),
    REGISTER_EXCEPTION(1013, "注册异常"),
    UPLOAD_FILE_FAIL(1014, "上传文件失败"),
    QUERY_FAIL(1015, "查询失败"),
    USER_NOT_EXIST(1016, "用户不存在"),
    PARAMS_ILLEGAL(1017, "参数不合法"),
    Channel_Illegal(1018, "视频频道类型不合法"),
    PUBLISH_FAIL(1019, "发布视频失败"),
    EXECUTE_FAIL(1020, "操作执行失败");

    private Integer code;
    private String msg;

    private ResultEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
