package com.TCU.WEBSOCKET;


import com.TCU.Result.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @ Author: 张震霆
 * @ Date: 2022/06/16/14:38
 * @ Description:
 */
@RestController
@Slf4j
@Api(value = "WebsocketController",tags = "Describe")
public class WebsocketController {
@Autowired
    WebSocketSendInfo webSocketSendInfo;
    @GetMapping("/sendAllWebSocket")
    public Object sendAllWebSocket(@RequestParam("username") String username, @RequestParam("password") String password) throws IOException {
        String sendINfo = webSocketSendInfo.SendINfo();
        if (username.isEmpty()||password.isEmpty()) {
            log.info("invalid Param", Result.ResUser("UserName:"+username+"|"+"PassWord"+password));
            return  Result.ResUser("UserName:"+username+"|"+"PassWord"+password);
        }
        else {
            if(username.equals("Tcu")&&password.equals("10029")){
                log.info("sendINfo",Result.ResUserLACC(sendINfo));
                return MyWebSocketServer.sendInfo(sendINfo);
            }
        }
        return Result.ResUser("UserName or PassWord error");
    }
}