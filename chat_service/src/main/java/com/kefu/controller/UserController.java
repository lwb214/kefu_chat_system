package com.kefu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kefu.dto.req.LoginReq;
import com.kefu.dto.res.LoginRes;
import com.kefu.mapper.entity.User;
import com.kefu.service.IUserService;
import com.kefu.util.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private IUserService userService;
    @GetMapping("get")
    public Result<User> getUser(@RequestBody Integer id){
        User user = userService.getById(id);
        return Result.success(user);
    }
    @GetMapping("getAll")
    public Result<Page> getPage(@RequestBody Page page){
        Page userPage = userService.page(page);
        return Result.success(userPage);
    }
    @PostMapping("login")
    public Result<LoginRes> login(@RequestBody LoginReq loginReq){
        return userService.login(loginReq);
    }
}
