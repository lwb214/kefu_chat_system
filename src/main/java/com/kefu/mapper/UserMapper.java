package com.kefu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kefu.mapper.entity.User;
import org.apache.ibatis.annotations.Mapper;
/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/13 20:38
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
