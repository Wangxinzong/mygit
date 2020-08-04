package com.activemq.example.bootAMQ.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

@Component
public class TopicProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Topic topic;

    public void sendTopic() {
        jmsMessagingTemplate.convertAndSend(topic, "---主题消息----");
    }
}
