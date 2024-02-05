package com.kefu.util;

import com.kefu.mapper.entity.User;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;
import java.util.HashMap;


@Slf4j
public class JwtUtil {
    //设置密钥
    public static final String secret="lwb_secret";

    public static String createToken(User user){
        //构造头部
        HashMap<String, Object> header = new HashMap<>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");
        //构造荷载
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("userId",user.getUserid());
        claims.put("username",user.getUsername());
        claims.put("password",user.getPassword());

        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secret)
                .setHeader(header)
                .setClaims(claims)
                .setIssuedAt(new Date())
                //过期时间24小时
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000));
        //构建token
        return jwtBuilder.compact();
    }
    //解析token
    public static Claims checkToken(String token) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            log.error("token已过期:{}",token,e);
        } catch (Exception e) {
            log.error("token不合法转换异常:{}",token,e);
        }
        return null;
    }
}
