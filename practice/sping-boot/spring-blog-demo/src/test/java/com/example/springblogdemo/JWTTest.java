package com.example.springblogdemo;


import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTest {
    private long Expiration = 24 * 60 * 60 * 1000;//24小时
    String secretString = "r4IOWSJS078ydifUtTojEnRFSsGoZFOnTDRckceAxiM=";
    Key key = Keys.hmacShaKeyFor(secretString.getBytes());
    @Test
    /***
     * 生成令牌
     */
    public void genJwt() {
        Map<String, Object> claim = new HashMap<>();
        claim.put("id",1);
        claim.put("name", "test");
        String jwtBuilder = Jwts.builder()
                .setClaims(claim)//设置载荷
                .setIssuedAt(new Date())//设置创建时间
                .setExpiration(new Date(System.currentTimeMillis() + Expiration))//设置过期时间
                .signWith(key)//使用密钥签名
                .compact();//生成JWT
        System.out.println(jwtBuilder);
    }

    @Test
    /**
     * 生成一个随机的符合加密条件的密钥
     */
    public void genKey() {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String encode = Encoders.BASE64.encode(secretKey.getEncoded());
        System.out.println(encode);
    }

    @Test
    /**
     * 解析JWT
     */
    public void parseJwt() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidGVzdCIsImlkIjoxLCJpYXQiOjE3OTI0ODIzODUsImV4cCI6MTc5MjU2ODc4NX0.fRXt5CvWrrmIFoBWmIquO4pbZVXD8WAzXGAbEly2774\n";
        //创建解析器
        JwtParser build = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();
        //解析JWT
        Claims claims = build.parseClaimsJws(token).getBody();
        System.out.println(claims);
    }
}
