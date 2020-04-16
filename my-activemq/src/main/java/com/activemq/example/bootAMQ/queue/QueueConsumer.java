package com.activemq.example.bootAMQ.queue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    @JmsListener(destination = "${queueName}")
    public void receiveQueue(String text){
        System.out.println("接收到队列消息:"+text);
    }
}
