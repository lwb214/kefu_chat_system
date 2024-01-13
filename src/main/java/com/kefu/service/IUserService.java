package com.kefu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kefu.mapper.entity.User;
import com.kefu.util.R;

/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/13 20:39
 */
public interface IUserService extends IService<User> {
    R updateUser(User user);
}
