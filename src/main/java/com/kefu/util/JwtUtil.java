package com.kefu.util;

import com.kefu.mapper.entity.User;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author 路文斌
 * @Date 2024/1/15 0:34
 */
@Slf4j
public class JwtUtil {
    public static final String secret="lwb_secret";

    public static String createToken(User user){
        HashMap<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        HashMap<String, Object> claims = new HashMap<>();

        Field[] fields = user.getClass().getFields();
        for(Field field:fields){
            claims.put(field.getName(), field);
        }

        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secret)
                .setHeader(header)
                .setClaims(claims)
                .setIssuedAt(new Date())
                //1天过期
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000));
        //生成契约
        String token = jwtBuilder.compact();
        return token;
    }

    public static Map<String, Object> checkToken(String token) {
        try {
            Jwt parse = Jwts.parser().setSigningKey(secret).parse(token);
            return (Map<String, Object>) parse.getBody();
        } catch (ExpiredJwtException e) {
            log.error("token已过期：{}",token,e);
        } catch (Exception e) {
            log.error("token不合法转换异常：{}",token,e);
        }
        return new HashMap<>();
    }
}
