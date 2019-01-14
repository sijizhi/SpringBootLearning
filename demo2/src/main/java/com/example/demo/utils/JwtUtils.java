package com.example.demo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: SiJie Zhi
 * @Date: 2018/12/15 17:54
 */
public class JwtUtils {
    /**
     * 密钥
     */
    private static  final String SECRET="tongfuidoc!@#$%!#";
    /**
     * 默认字段key:exp
     */
    private static final String EXP="exp";
    /**
     * 默认字段key:payload
     */
    private static final String PAYLOAD="payload";

    /**
     * 加密
     * @param object 加密数据
     * @param maxTime 有效期（毫秒数）
     * @param <T>
     * @return
     */
    public static <T> String encode(T object,long maxTime){
        //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        try{
//            final JWTSigner signer=new JWTSigner(SECRET);
//            final Map<String ,Object> data=new HashMap<>(10);
            ObjectMapper objectMapper=new ObjectMapper();
            String jsonString=objectMapper.writeValueAsString(object);
//            data.put(PAYLOAD,jsonString);
//            data.put(EXP,System.currentTimeMillis()+maxTime);
//            return signer.sign(data);
            Map<String, Object> map = new HashMap<String, Object>();
            //下面就是在为payload添加各种标准声明和私有声明了
            map.put(PAYLOAD, jsonString);
            map.put(EXP,System.currentTimeMillis()+maxTime);
            //这里其实就是new一个JwtBuilder，设置jwt的body
            JwtBuilder builder = Jwts.builder()
                    .setClaims(map)
                    //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                    //.setId(UUID.randomUUID().toString())
                    //iat: jwt的签发时间
                    .setIssuedAt(now)
                    //设置签名使用的签名算法和签名使用的秘钥
                    .signWith(signatureAlgorithm, SECRET);
            if (maxTime >= 0) {
                long expMillis = nowMillis + maxTime;
                Date exp = new Date(expMillis);
                //设置过期时间
                builder.setExpiration(exp);
            }
            return builder.compact();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 数据解密
     * @param jwt 解密数据
     * @param tClass 解密类型
     * @param <>
     * @return
     */
    public static Claims  decode(String jwt){
        try{

            //得到DefaultJwtParser
            final   Claims claims = Jwts.parser()
                    //设置签名的秘钥
                    .setSigningKey(SECRET)
                    //设置需要解析的jwt
                    .parseClaimsJws(jwt).getBody();
            Object claims2 =Jwts.parser().setSigningKey(SECRET).parse(jwt).getBody();
            String json=(String) claims.get(PAYLOAD);
            ObjectMapper objectMapper=new ObjectMapper();
            return claims;
           // return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
