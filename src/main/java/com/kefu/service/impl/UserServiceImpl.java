package com.kefu.service.impl;

import com.alibaba.druid.sql.visitor.functions.If;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kefu.dto.req.LoginReq;
import com.kefu.dto.res.LoginRes;
import com.kefu.enums.RedisKeyPreEnum;
import com.kefu.mapper.UserMapper;
import com.kefu.mapper.entity.User;
import com.kefu.service.IUserService;
import com.kefu.util.JwtUtil;
import com.kefu.util.R;
import com.kefu.util.RedisUtil;
import com.kefu.util.Result;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/13 20:40
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<BaseMapper<User>, User> implements IUserService{
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public R updateUser(User user) {
        return null;
    }

    @Override
    public Result<LoginRes> login(LoginReq loginReq) {
    log.info("登录请求:{}", JSON.toJSONString(loginReq));

    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.and(qw->{
        qw.eq("username",loginReq.getUsername());
    });
    LoginRes loginRes = new LoginRes();

    User user = userMapper.selectOne(queryWrapper);
    if(ObjectUtils.isEmpty(user)){
        loginRes.setLoginStatus(false);
        loginRes.setFailMessage("用户名不存在,请先注册");
        return Result.fail(loginRes);
    }
    queryWrapper.and(qw->{
        qw.eq("username",loginReq.getUsername());
        qw.eq("password",loginReq.getPassword());
    });
    user = userMapper.selectOne(queryWrapper);
    if (ObjectUtils.isEmpty(user)){
        loginRes.setLoginStatus(false);
        loginRes.setFailMessage("用户名或密码错误");
        return Result.fail(loginRes);
    }
    String token = JwtUtil.createToken(user);
    redisUtil.setObject(String.valueOf(RedisKeyPreEnum.TOKEN_PRE),token);
    loginRes.setToken(token);
    loginRes.setFailMessage("登陆成功");
    loginRes.setLoginStatus(true);
    return Result.success(loginRes);
    }
}
