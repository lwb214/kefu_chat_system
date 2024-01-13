package com.kefu.testMapper;

import com.alibaba.fastjson2.JSON;
import com.kefu.mapper.UserMapper;
import com.kefu.mapper.entity.User;
import com.kefu.service.IUserService;
import jakarta.annotation.Resource;
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
    @Resource
    private UserMapper userMapper;
    @Test
    public void test01(){
        Integer id = 1;
        User user = userMapper.selectById(id);
        log.info("ok", JSON.toJSONString(user));
    }
}
