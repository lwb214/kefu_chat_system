package com.kefu.common.enums;

import com.kefu.common.commend.Commend;
import lombok.Getter;

@Getter
public enum CommendEnums implements Commend {
    LOGIN(0),

    ;
    private final int code;

    CommendEnums(int code) {
        this.code = code;
    }

    @Override
    public Integer getCommend() {
        return code;
    }
}
