package com.kefu.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kefu.mapper.entity.User;
import com.kefu.service.iservice.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/13 20:40
 */
@Service
public class UserServiceImpl extends ServiceImpl<BaseMapper<User>, User> implements IUserService{
}
