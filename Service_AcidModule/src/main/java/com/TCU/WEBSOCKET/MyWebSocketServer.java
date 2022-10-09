package com.TCU.WEBSOCKET;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author zzt
 */
//@ServerEndpoint("/webSocket/{CorpID}")
//@Component
public class MyWebSocketServer {

    static Log log=LogFactory.get(MyWebSocketServer.class);
    /**静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。*/
    private static int onlineCount = 0;
    /**concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。*/
    private static ConcurrentHashMap<String,MyWebSocketServer> webSocketMap = new ConcurrentHashMap<>();
    /**与某个客户端的连接会话，需要通过它来给客户端发送数据*/
    private Session session;
    /**接收userId*/
    private String CorpID="";

    /**
     * 发送自定义消息
     * */
    public static String sendInfo(String message) throws IOException {

        log.info("发送消息报文:"+message);
            return message;
    }

    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session,@PathParam("CorpID") String CorpID) {
        this.session = session;
        this.CorpID=CorpID;
        if(webSocketMap.containsKey(CorpID)){
            webSocketMap.remove(CorpID);
            webSocketMap.put(CorpID,this);
            //加入set中
        }else{
            webSocketMap.put(CorpID,this);
            //加入set中
            addOnlineCount();
            //在线数加1
        }

        log.info("用户连接:"+CorpID+",当前在线人数为:" + getOnlineCount());

        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("用户:"+CorpID+",网络异常!!!!!!");
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session,@PathParam("COrpId") String COrpId) {
        //可以群发消息
        //消息保存到数据库、redis
        log.info("发送消息到:"+COrpId+"，报文:"+message);
        if(webSocketMap.containsKey(COrpId)){
            try {
                webSocketMap.get(COrpId).sendMessage(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            log.error("用户"+COrpId+",不在线！");
        }

    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if(webSocketMap.containsKey(CorpID)){
            webSocketMap.remove(CorpID);
            //从set中删除
            subOnlineCount();
        }
        log.info("用户退出:"+CorpID+",当前在线人数为:" + getOnlineCount());
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户错误:"+this.CorpID+",原因:"+error.getMessage());
        error.printStackTrace();
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        MyWebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        MyWebSocketServer.onlineCount--;
    }
}
