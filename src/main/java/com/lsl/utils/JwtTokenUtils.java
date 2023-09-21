package com.lsl.utils;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtTokenUtils {

    @Value("${jwt.secretKey}")
    private String secretKey;

    public String createJWT(String openid, String subject, long ttlMillis, Map<String, Object> map) throws Exception {
        JwtBuilder builder = Jwts.builder()
                .setId(openid)//设置唯一编号
                .setSubject(subject) // 发行者
                .setIssuedAt(new Date()) // 发行时间
                .signWith(SignatureAlgorithm.HS256, secretKey) // 设置签名 使用HS256算法 并设置SecretKey(字符串)(密钥)
                .compressWith(CompressionCodecs.DEFLATE);// 对载荷进行压缩
        if (!CollectionUtils.isEmpty(map)) {
            builder.setClaims(map);
        }
        if (ttlMillis > 0) {
            builder.setExpiration(new Date(System.currentTimeMillis() + ttlMillis));//设置过期时间
        }
        return builder.compact();
    }


    public Claims parseJWT(String jwtString) {
        return Jwts.parser().setSigningKey(secretKey)
                .parseClaimsJws(jwtString)
                .getBody();
    }

}

