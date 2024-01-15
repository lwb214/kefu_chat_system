package com.kefu.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/15 11:02
 */
@Data
@AllArgsConstructor
@Builder
public class LoginRes {
    private String token;
}
