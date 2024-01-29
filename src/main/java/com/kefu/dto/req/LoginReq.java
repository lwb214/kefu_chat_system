package com.kefu.dto.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/15 10:53
 */
@Data
public class LoginReq implements Serializable {

    private static final long serialVersionUID = -3604009773196130878L;

    private String username;
    private String password;
}
