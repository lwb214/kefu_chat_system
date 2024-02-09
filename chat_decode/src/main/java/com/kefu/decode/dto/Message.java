package com.kefu.decode.dto;

import lombok.Data;

@Data
public class Message {

    private MessageHeader messageHeader;
    private Object messageData;

    @Override
    public String toString() {
        return "Message{" +
                "messageHeader=" + messageHeader +
                ", messageData=" + messageData +
                '}';
    }
}
