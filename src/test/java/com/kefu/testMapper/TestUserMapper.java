package com.kefu.testMapper;

import com.alibaba.fastjson.JSON;
import com.kefu.mapper.UserMapper;
import com.kefu.mapper.entity.User;
import com.kefu.service.iservice.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/13 21:52
 */
@SpringBootTest
@Slf4j
public class TestUserMapper {
    private UserMapper userMapper;
    private IUserService userService;
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Test
    public void test01(){
        Integer id = 1;
        User user = userMapper.selectById(id);
        log.info("ok",user);
    }
    @Test
    public void test02(){
        Integer id = 1;
        User user = userService.getById(id);
        log.info("ok", JSON.toJSONString(user));
    }
}
