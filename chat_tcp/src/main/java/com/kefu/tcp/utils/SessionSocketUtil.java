package com.kefu.tcp.utils;

import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionSocketUtil {
    private static final Map<String, NioSocketChannel> CHANNELS = new ConcurrentHashMap<>();

    public static void put(String userId,NioSocketChannel channel){
        CHANNELS.put(userId,channel);
    }

    public static NioSocketChannel get(String userId){
        return CHANNELS.get(userId);
    }

    RedissonClient client = Redisson.create();
}
