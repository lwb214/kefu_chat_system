package com.kefu.dto.req;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class LoginReq implements Serializable {

    @Serial
    private static final long serialVersionUID = -3604009773196130878L;

    private String userid;
    private String password;
}
