package com.kefu.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/15 11:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRes  implements Serializable {

    private static final long serialVersionUID = 5403226952345218365L;

    private boolean LoginStatus;
    private String token;
    private String failMessage;
}
