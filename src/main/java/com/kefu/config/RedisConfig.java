package com.kefu.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/13 23:47
 *
 */
@Configuration
@Slf4j
public class RedisConfig {
    @Autowired
    private RedisConnectionFactory factory;

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //序列化
        //如需使用类自动化装配（redis直接存储类对象），请使用类FastJson2RedisSerializer序列化
        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        // value值的序列化采用fastJsonRedisSerializer
        template.setDefaultSerializer(fastJsonRedisSerializer);
        log.info("redis client初始化完成");
        return template;
    }
}
