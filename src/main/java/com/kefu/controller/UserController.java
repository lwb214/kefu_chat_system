package com.kefu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kefu.mapper.entity.User;
import com.kefu.service.IUserService;
import com.kefu.util.R;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/13 20:44
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private IUserService userService;
    @GetMapping("get")
    public R getUser(@RequestBody Integer id){
        User user = userService.getById(id);
        return R.success(user);
    }
    @GetMapping("getAll")
    public R getPage(@RequestBody Page page){
        IPage<User> userPage = userService.page(page);
        return R.success(userPage);
    }
}
