package com.TCU2.WXOAUTH2;


import com.TCU2.Result.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

import static com.TCU2.Config.HttpClientHelper.SendGet;


@RestController
@Slf4j
@Api("Async Login ")
public class  DEMOMO {
//    private final String COPRIDLEN=URLEncoder.encode("wx57f1d735cc485486", UTF_8);
//    private final String REDIRECT_URL=URLEncoder.encode("https://hsjc.tcu.edu.cn", UTF_8);
//    private final String SECRET1 = "wJAhaIYfxki3bVv7OPFH2fBrv1I03k6_mybgy9PBQn0";
//    private final String COPRID = "Wx57f1d735cc485486";
//    private final String AGENTID="1000029";
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * pull CodeInfo
     */

    @GetMapping(value = "/PullOrPushUser")
    public Object PullOrPushUser(String code) throws IOException {
        //从redisTem 中获得定时刷新的ACK
       String ack=stringRedisTemplate.opsForValue().get("ack");
       if(ack.equals(null)){
           log.error("ACK==>Valid", Result.ResUserAckError(ack));
       }
        String Ouath2Userid ="https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token="+ack+"&code="+code;
        //向企业Server 发送请求获得UserID
       String res2= SendGet(Ouath2Userid);
        com.alibaba.fastjson.JSONObject jsonObject= (com.alibaba.fastjson.JSONObject)  com.alibaba.fastjson.JSON.parse(res2);
        String Id= String.valueOf(jsonObject.get("UserId"));
        log.info("markerUserid",Id);
        String oauth2Userinfo = "https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token="+ack+"&userid="+Id;
        String res3= SendGet(oauth2Userinfo);
        com.alibaba.fastjson.JSONObject js= (com.alibaba.fastjson.JSONObject)  com.alibaba.fastjson.JSON.parse(res3);
        log.info("user",js);
        return js;
    }






}
