package com.kefu.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kefu.dto.req.LoginReq;
import com.kefu.dto.res.LoginRes;
import com.kefu.mapper.entity.User;
import com.kefu.service.IUserService;
import com.kefu.util.R;
import com.kefu.util.RedisUtil;
import com.kefu.util.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/13 20:40
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<BaseMapper<User>, User> implements IUserService{
    @Resource
    private RedisUtil redisUtil;

    @Override
    public R updateUser(User user) {
        return null;
    }

    @Override
    public Result<LoginRes> login(LoginReq loginReq) {
    log.info("登录请求:{}", JSON.toJSONString(loginReq));

        return null;
    }
}
