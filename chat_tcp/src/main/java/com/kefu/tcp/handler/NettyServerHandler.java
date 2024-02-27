package com.kefu.tcp.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.kefu.common.enums.CommendEnums;
import com.kefu.decode.dto.LoginDto;
import com.kefu.decode.dto.Message;
import com.kefu.tcp.utils.SessionSocketUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

public class NettyServerHandler extends SimpleChannelInboundHandler<Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        //登录逻辑
        Integer commend = msg.getMessageHeader().getCommend();
        if(commend.equals(CommendEnums.LOGIN.getCode())){

            LoginDto loginDto = JSON.parseObject(JSON.toJSONString(msg.getMessageHeader()),new TypeReference<LoginDto>(){}.getType());

            ctx.channel().attr(AttributeKey.valueOf("userId")).set(loginDto.getUserId());
            //channel存起来
            SessionSocketUtil.put(loginDto.getUserId(),(NioSocketChannel) ctx.channel());
        }
    }
}
