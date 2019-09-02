package com.learn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Created by Administrator on 2019/9/2.
 */

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    //注册一个websocket端点,客户端使用它连接到我们的websocket服务器

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        // withSockJS()是为不支持websocket的浏览器启用后备选项.
        registry.addEndpoint("/ws").withSockJS();
    }


    //配置了一个消息代理(这里是内存中的消息代理),将消息从一个客户端到另一个客户端去.

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        //第一行定义了以"/app"开头的消息应该路由到消息处理方法(后续会定义)
        registry.setApplicationDestinationPrefixes("/app");
        //第二行定义了以"/topic"开头的消息应该路由到消息代理. 消息代理向订阅了特定主题的所有连接客户端广播消息
        registry.enableSimpleBroker("/topic");
    }

}
