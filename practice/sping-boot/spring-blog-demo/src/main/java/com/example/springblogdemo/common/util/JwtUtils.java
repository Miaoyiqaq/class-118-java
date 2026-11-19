package com.example.springblogdemo.common.util;

import com.example.springblogdemo.common.exception.BlogException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtUtils {
    private static final long Expiration = 7 * 24 * 60 * 60 * 1000;//7天
    //TODO 后续应将密钥保存在配置文件中
    private static final String jwtToken = "r4IOWSJS078ydifUtTojEnRFSsGoZFOnTDRckceAxiM=";
    private static final Key key = Keys.hmacShaKeyFor(jwtToken.getBytes());

    /***
     * 生成令牌
     * @return
     */
    public static String genJwt(String userId, String username) {
        Map<String, Object> claim = new HashMap<>();
        claim.put("id", userId);
        claim.put("name", username);
        String jwtBuilder = Jwts.builder()
                .setClaims(claim)//设置载荷
                .setIssuedAt(new Date())//设置创建时间
                .setExpiration(new Date(System.currentTimeMillis() + Expiration))//设置过期时间
                .signWith(key)//使用密钥签名
                .compact();//生成JWT
        return jwtBuilder;
    }


    /**
     * 生成一个随机的符合加密条件的密钥
     */
    public void genKey() {
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String encode = Encoders.BASE64.encode(secretKey.getEncoded());
        System.out.println(encode);
    }


    /**
     * 解析JWT
     * @return
     */
    public static Claims parseJwt(String jwt) {
//        if(jwt == null) {
//            return null;
//        }
        //创建解析器
        JwtParser build = Jwts.parserBuilder()
                .setSigningKey(key)
                .build();
        //解析JWT
        try {
            return build.parseClaimsJws(jwt).getBody();
        } catch (ExpiredJwtException e) {
            String msg = String.format("令牌已过期.过期时间:%s", e.getClaims().getExpiration());
            log.warn(msg);
            throw new BlogException(msg);
        } catch (SignatureException e) {
            String msg = String.format("令牌签名验证失败.检查密钥是否正确:%s", e.getMessage());
            log.warn(msg);
            throw new BlogException(msg);
        } catch (MalformedJwtException e) {
            String msg = String.format("令牌格式错误.检查令牌是否正确:%s", e.getMessage());
            log.warn(msg);
            throw new BlogException(msg);
        } catch (UnsupportedJwtException e) {
            String msg = String.format("不支持的令牌算法.检查令牌是否正确.不支持的令牌算法:%s", e.getMessage());
            log.warn(msg);
            throw new BlogException(msg);
        } catch (PrematureJwtException e) {
            String msg = String.format("令牌未生效.令牌提前使用:%s", e.getMessage());
            log.warn(msg);
            throw new BlogException(msg);
        } catch (IllegalArgumentException e) {
            String msg = String.format("令牌不存在,请登录:%s", e.getMessage());
            log.warn(msg);
            throw new BlogException(msg);
        } catch (JwtException e) {
            String msg = String.format("JWT解析异常:%s", e.getMessage());
            log.warn(msg);
            throw new BlogException(msg);
        }
    }
}
