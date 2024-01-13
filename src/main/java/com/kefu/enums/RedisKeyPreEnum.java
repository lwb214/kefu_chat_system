package com.kefu.enums;

/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/14 1:12
 */
public enum RedisKeyPreEnum {

    USER_PRE(1,"用户前缀");
    //key分类
   private Integer type;
    //key描述
   private String desc;

   private RedisKeyPreEnum(Integer type,String desc){
       this.type = type;
       this.desc = desc;
   }
}
