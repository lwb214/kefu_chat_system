package com.kefu.mapper.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@Description
 *@Author 路文斌
 *@Date 2024/1/13 20:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User extends Model<User> {
    private Integer id;
    private Integer userid;
    private String username;
    private String password;
    private Integer sex;
    private String idCard;
    private String phoneNumber;
    private Integer balance;//余额
}
