package com.kefu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kefu.mapper.entity.User;
import com.kefu.service.iservice.IUserService;
import com.kefu.util.R;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/13 23:25
 */
public class UserService {
    private IUserService userService;
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
    public IPage<User> page(Page page){
       return userService.page(page);
    }
}
