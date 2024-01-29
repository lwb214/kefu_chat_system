package com.kefu.enums;

import lombok.Getter;

/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/14 1:12
 */
@Getter
public enum RedisKeyPreEnum {

    USER_PRE(1,"用户前缀"),

    TOKEN_PRE(2,"登录token前缀");

    //key分类
   private Integer type;
    //key描述
   private String desc;

   private RedisKeyPreEnum(Integer type,String desc){
       this.type = type;
       this.desc = desc;
   }
}
