package com.example;

import com.example.entity.Content;
import org.springframework.stereotype.Component;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

//@ServerEndpoint(value="/websocket",configurator = SpringConfigurator.class)
@ServerEndpoint(value="/websocket")
@Component
public class MyWebSocket {
    private static int onlineCount=0;
//    @Autowired
//    private ContentService conteneService;

    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet =new CopyOnWriteArraySet<MyWebSocket>();

    private Session session;

    public MyWebSocket(){
        System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
    }
    //少了onClose方法，关闭的时候这边的没有关闭
    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("有新的连接加入，当前人数为"+getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("来自客户端的消息："+message);
        for(MyWebSocket myWebSocket: webSocketSet){
            try {
                myWebSocket.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
//                webSocketSet.remove(myWebSocket);
            } catch (IllegalStateException e){
                e.printStackTrace();
                webSocketSet.remove(myWebSocket);
            }
        }
    }

    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    private void sendMessage(String message) throws IOException{
        Content content =new Content();
        content.setContent(message);
        SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        content.setCreateDate(sm.format(new Date()));
//        conteneService.insertSelective(content);
        this.session.getBasicRemote().sendText(message);
    }

    private static synchronized void subOnlineCount(){
        MyWebSocket.onlineCount--;
    }
    private static synchronized int getOnlineCount(){
        return onlineCount;
    }
    private static synchronized void addOnlineCount(){
        MyWebSocket.onlineCount++;
    }
}
