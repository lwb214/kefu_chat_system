package com.kefu.util;

import com.kefu.mapper.entity.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.DefaultClaims;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/19 17:13
 */
@Slf4j
public class JwtUtil {
    //JWT签名秘钥
    public static final String secretKey = "JWT-SECRET";
    public static String createToken(User user) throws IllegalAccessException {
        // JWT头部信息【Header】
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        //JWT荷载信息【Payload】
        HashMap<String,Object> payload = new HashMap<>();
        payload.put("sub",1234567890);
        Field[] fields = user.getClass().getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            String name = field.getName();
            Object value = field.get(user);
            payload.put(name,value);
        }

        JwtBuilder jwtBuilder = Jwts.builder()
                .setHeader(header)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setClaims(payload)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 3 * 1000));
        String token = jwtBuilder.compact();
        return token;
    }


    public static Claims checkToken(String token){
        Claims claims = new DefaultClaims();
        try {
            claims =  Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            log.error("token已过期:{}",token,e);
        } catch (Exception e) {
            log.error("token不合法转换异常:{}",token);
        }

        return claims;
    }
}
