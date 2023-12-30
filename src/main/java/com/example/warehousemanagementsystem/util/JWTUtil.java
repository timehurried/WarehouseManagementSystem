package com.example.warehousemanagementsystem.util;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Calendar;
import java.util.Map;
/**
 * JWT工具类
 */
public class JWTUtil {

    /**
     * 密钥要自己保管好
     */
    private static String SECRET = "!Q@W#E$R";

    /**
     * 传入payload信息获取token
     * @param map payload
     * @return token
     */
    public static String getToken(Map<String, String> map) {
        JWTCreator.Builder builder = JWT.create();

        //payload
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 3); //默认3天过期

        builder.withExpiresAt(instance.getTime());//指定令牌的过期时间
        return builder.sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 验证token 合法性
     */
    public static DecodedJWT verify(String token) {
        //如果有任何验证异常，此处都会抛出异常
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
    }

    /**
     * 获取token信息方法
     */
    public static Map<String, Claim> getTokenInfo(String token) {

        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token).getClaims();
    }


}
