package com.wxz.mqapplication.activemq.bootAMQ.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
@EnableJms
public class AMQConfig {

    @Value("${queueName}")
    private String queueName;

    @Value("${topicName}")
    private String topicName;

    @Bean
    public Queue createQueue() {
        return new ActiveMQQueue(queueName);
    }

    @Bean
    public Topic createTopic() {
        return new ActiveMQTopic(topicName);
    }

}
