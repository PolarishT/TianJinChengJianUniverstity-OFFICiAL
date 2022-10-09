package com.TCU.Redis;


import com.TCU.Config.HttpClientHelper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.io.IOException;

@Service
public class RedisaCache {

@Resource
    StringRedisTemplate stringRedisTemplate;//12=12*60*1000
@Async("AccessTokenPool")
    @Scheduled(fixedRate = 720000,initialDelay = 1000)
    public void RedisCacheInvalidtePut()throws IOException {
    String SECRET1 = "WJAhaIYfxki3bVv7OPFH2fBrv1I03k6_mybgy9PBQn0";
    String ID = "wx57f1d735cc485486";
    String oauth2token = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + ID + "&corpsecret=" + SECRET1;
    String resps = HttpClientHelper.SendGet(oauth2token);
    com.alibaba.fastjson.JSONObject jsonObject = (com.alibaba.fastjson.JSONObject) com.alibaba.fastjson.JSON.parse(resps);
    String ackT= (String) jsonObject.get("access_token");
    stringRedisTemplate.opsForValue().set("ack",ackT);
    }

}
