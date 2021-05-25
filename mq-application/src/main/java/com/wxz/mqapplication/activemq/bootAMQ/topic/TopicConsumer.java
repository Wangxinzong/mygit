package com.wxz.mqapplication.activemq.bootAMQ.topic;

import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {

    //@JmsListener(destination = "${topicName}")
    public void receiveTopic(String message) {
        System.out.println("接收到的主题消息:" + message);
    }
}
