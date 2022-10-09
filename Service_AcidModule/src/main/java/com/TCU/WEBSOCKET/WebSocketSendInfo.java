package com.TCU.WEBSOCKET;

import com.TCU.Utils.JWTToken;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class WebSocketSendInfo {

    public String SendINfo(){
        String CorpID = "1000029";
        long date = new Date().getTime();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Date = simpleDate.format(date);
        // 间隔10 min 生成一个 Token
        String token= JWTToken.createToken(10029);
        //set ->  map
        String map = "https://hsjc.tcu.edu.cn" + "/" + CorpID + "/" + token + "/"+Date;
        return map;
    }


    //个人的信息
}
