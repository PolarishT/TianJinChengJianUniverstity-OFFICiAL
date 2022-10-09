package com.TCU.Utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.ibatis.logging.Log;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTToken {

        //私钥
        private static final String SECRET = "Tcu核酸检测";

        //过期时间1分钟 1*60*1000
        private static final int expiresTime = 3000;

        public static String createToken(Integer CopID) {
            //获取加上过期时间后的时间
            Date nowDate = new Date();
            System.out.println(nowDate);
            Date expiresDate = new Date(System.currentTimeMillis() + expiresTime);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("alg", "HS256");
            map.put("typ", "JWT");
            String token = JWT.create().withHeader(map)    //请求头
                         .withClaim("iss", "Service")    //签发方
                         .withClaim("aud", "Client")        //接收方
                         .withClaim("CopID", null == CopID ? null : CopID.longValue()) //存储信息，用户ID
                         .withIssuedAt(nowDate)        //当前时间
                         .withExpiresAt(expiresDate)        //过期时间
                         .sign(Algorithm.HMAC256(SECRET));        //私钥

            return token;
        }
        //以下为验证token的

        public static boolean verifyToken(String token){
            try{
                JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
                verifier.verify(token);
                //DecodedJWT verify = verifier.verify(token);
                //return verify.getClaims();	//能返回数据集合(用于在jwt中存储一些数据)的，但是由于这一版本只需要核验token是否合法，所以只需要返回true和false；
                return true;
            }catch(Exception e){
                Log log = null;
                log.error(e.getMessage(), e);
                return false;
            }
        }





    }


