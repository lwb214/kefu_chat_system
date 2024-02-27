package com.kefu.dto.req;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class RegisterReq implements Serializable {
    @Serial
    private static final long serialVersionUID = 6759684358809751784L;

    private String userid;
    private String username;
    private String password;
    private Integer sex;
    private String idCard;
    private String phoneNumber;
    private Integer balance;
}
