package com.kefu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kefu.dto.req.LoginReq;
import com.kefu.dto.res.LoginRes;
import com.kefu.mapper.entity.User;
import com.kefu.util.R;
import com.kefu.util.Result;


public interface IUserService extends IService<User> {
    R updateUser(User user);

    Result<LoginRes> login(LoginReq loginReq);
}
