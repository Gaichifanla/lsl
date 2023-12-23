package com.lsl.config;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/websocket/{userId}")//将该类标记为WebSocket服务器端的端点
@Component
public class WebSocketServer {
    static Log log= LogFactory.get(WebSocketServer.class);

    private static int onlineCount = 0;

    private static ConcurrentHashMap<String,WebSocketServer> webSocketMap =new ConcurrentHashMap<>();
    private Session session;
    private String userId="";

    //存放websocket的集合
    private static CopyOnWriteArraySet<WebSocketServer> webSocketServerSet =new CopyOnWriteArraySet<>();

    //前端请求一个websocket时
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId){
        this.session=session;
        this.userId=userId;
        if (webSocketMap.containsKey(userId)){
            webSocketMap.remove(userId);
            webSocketMap.put(userId,this);
        }else {
            webSocketMap.put(userId,this);
            addOnlineCount();
        }
        webSocketServerSet.add(this);
        log.info("【websocket消息】有新的连接用户:"+userId+", 当前在线人数:{}", webSocketServerSet.size());
        try{
            sendMessage("连接成功");
        }catch (IOException e){
            log.error("用户:"+userId+",网络异常！");
        }
    }

    /**
     * 链接关闭调用的方法
     */
    @OnClose
    public void OnClose(){
        if(webSocketMap.containsKey(userId)){
            webSocketMap.remove(userId);
            subOnlineCount();
        }
        log.info("用户退出:"+userId+",当前在线人数为:" + getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message,Session session){
        log.info("用户消息:"+userId+",报文:"+message);
        //判断给定的字符串message是否不为空且不只包含空格字符
        if(StringUtils.isNotBlank(message)){
            try {
                //解析发送的报文
                JSONObject jsonObject = JSON.parseObject(message);
                //追加发送人(防止串改)
                jsonObject.put("fromUserId",this.userId);
                String toUserId=jsonObject.getString("toUserId");
                //传送给对应toUserId用户的websocket
                if(StringUtils.isNotBlank(toUserId)&&webSocketMap.containsKey(toUserId)){
                    webSocketMap.get(toUserId).sendMessage(jsonObject.toJSONString());
                }else{
                    log.error("请求的userId:"+toUserId+"不在该服务器上");
                    //否则不在这个服务器上，发送到mysql或者redis
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void onError(Session session,Throwable error){
        log.error("用户错误:"+this.userId+",原因:"+error.getMessage());
        error.printStackTrace();
    }
    /**
     * 实现服务器主动推送
     * @param message
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 发送自定义消息
     * @return
     */
    public static void sendInfo(String message,@PathParam("userId") String userId) throws IOException {
        log.info("发送消息到:"+userId+"，报文:"+message);
        if(StringUtils.isNotBlank(userId)&&webSocketMap.containsKey(userId)){
            webSocketMap.get(userId).sendMessage(message);
        }else {
            log.error("用户"+userId+",不在线！");
        }
    }
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

}
