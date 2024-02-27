package com.kefu.dto.res;

import com.kefu.mapper.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRes implements Serializable {
    @Serial
    private static final long serialVersionUID = 7857563672328408946L;

    private boolean status;
    private User user;
    private String createTime;
    private String message;
//        得到当前时间
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String date = LocalDateTime.now().format(formatter);

}