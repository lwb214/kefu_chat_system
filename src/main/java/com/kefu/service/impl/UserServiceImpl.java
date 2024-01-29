package com.kefu.service.impl;


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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


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
    queryWrapper.and(qw-> qw.eq("userid",loginReq.getUserid()));
    LoginRes loginRes = new LoginRes();
    //先检验用户是否存在
    User user = userMapper.selectOne(queryWrapper);
    if(ObjectUtils.isEmpty(user)){
        loginRes.setLoginStatus(false);
        loginRes.setFailMessage("用户名不存在,请先注册");
        return Result.fail(loginRes);
    }
    //再检验密码是否正确
    queryWrapper.and(qw->{
        qw.eq("userid",loginReq.getUserid());
        qw.eq("password",loginReq.getPassword());
    });
    user = userMapper.selectOne(queryWrapper);
    if (ObjectUtils.isEmpty(user)){
        loginRes.setLoginStatus(false);
        loginRes.setFailMessage("用户名或密码错误");
        return Result.fail(loginRes);
    }
    //使用JWT生成token,存到redis
    String token = JwtUtil.createToken(user);
    redisUtil.setObject(RedisKeyPreEnum.TOKEN_PRE + user.getUserid(),token);

    loginRes.setToken(token);
    loginRes.setFailMessage("登陆成功");
    loginRes.setLoginStatus(true);
    return Result.success(loginRes);
    }
}
