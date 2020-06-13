# test-java-springwebsocket

是从spring-websocket教程拉取的代码，将init文件夹的内容进行完善，参考了其他人的博客<br>
前端使用了react，antd pro，拉下代码没做什么改动
放到了另一个仓库里[转到ui](https://github.com/FEITENGGUI/test-ui-websocket)

1. 一个WebSocketConfig类使用@Configuration进行注解，
使用@Bean注解serverEndpointExporter方法，
返回一个ServerEndpointExporter实例。
2. 一个MyWebSocket类使用@ServerEndpoint进行注解(写上value参数，这个参数是websocket的url)和@Component注解。
3. 给这个MyWebSocket类写一个静态成员变量用来保存这个websocket连接的实例，`CopyOnWriteArraySet<MyWebSocket> = webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();`。
4. 使用@OnOpen注解表示建立连接的时候调用的方法，在这里将`Session session`参数保存到`webSocketSet`里。
5. @OnMessage注解标注的方法是接受前台的消息时的方法
6. @OnClose注解标注的方法是断开连接时的方法
7. 主动推送消息的方法是`session.send($message)`，`$message`是推送的消息。


## 使用方法
1. 拉取代码。
2. 打开命令行，输入<br>`mvn idea:idea`<br>生成idea项目配置文件
3. 点击生成的`.ipr`文件打开idea，运行代码即可

###### 本人新手，欢迎提request一起讨论问题