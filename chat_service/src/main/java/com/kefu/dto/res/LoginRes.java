package com.kefu.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRes  implements Serializable {

    @Serial
    private static final long serialVersionUID = 5403226952345218365L;

    private boolean LoginStatus;
    private String token;
    private String message;
}
