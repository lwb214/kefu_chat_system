package com.kefu.decode.decoder;

import com.alibaba.fastjson.JSON;
import com.kefu.decode.dto.Message;
import com.kefu.decode.dto.MessageHeader;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

public class MessageDecoder extends ByteToMessageDecoder {
    //消息解码类
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> out) throws Exception {
        //请求头【指令+版本号+clientType+appID+dataLen】
        //请求体data
        if(byteBuf.readableBytes() < 20){
            return;
        }
        //获取指令
        int commend = byteBuf.readInt();
        //获取版本号
        int version = byteBuf.readInt();
        //获取客户端类型
        int clientType = byteBuf.readInt();
        //获取AppID
        int appId= byteBuf.readInt();
        //获取数据长度
        int dataLen = byteBuf.readInt();

        //如果小于数据长度，重置读索引
        if (byteBuf.readableBytes() < dataLen){
            byteBuf.resetReaderIndex();
            return;
        }

        byte[] dataArray = new byte[dataLen];
        byteBuf.readBytes(dataArray);
        String data = new String(dataArray);

        Message message = new Message();
        MessageHeader messageHeader = new MessageHeader();
        //构建消息头
        messageHeader.setCommend(commend);
        messageHeader.setVersion(version);
        messageHeader.setClientType(clientType);
        messageHeader.setAppId(appId);
        messageHeader.setDataLen(dataLen);
        //构建消息
        message.setMessageHeader(messageHeader);
        JSON body = (JSON) JSON.parse(data);
        message.setMessageData(body);

        //更新读索引
        byteBuf.markReaderIndex();
        out.add(message);
    }
}
