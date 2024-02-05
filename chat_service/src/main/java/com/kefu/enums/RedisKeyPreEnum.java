package com.kefu.enums;

import lombok.Getter;

@Getter
public enum RedisKeyPreEnum {

    USER_PRE(1,"用户前缀"),

    TOKEN_PRE(2,"登录token前缀");

    //key分类
   private final Integer type;
    //key描述
   private final String desc;

   RedisKeyPreEnum(Integer type,String desc){
       this.type = type;
       this.desc = desc;
   }
}
