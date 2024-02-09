package com.kefu.decode.dto;

import lombok.Data;

@Data
public class MessageHeader {
    //指令
    private Integer commend;
    //版本号
    private Integer version;
    //客户端类型
    private Integer clientType;
    //AppID
    private Integer appId;
    //数据长度
    private Integer dataLen;
}
