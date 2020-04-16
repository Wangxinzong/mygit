package com.activemq.example;

import com.activemq.example.bootAMQ.queue.QueueConsumer;
import com.activemq.example.bootAMQ.queue.QueueProducer;
import com.activemq.example.bootAMQ.topic.TopicProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyActivemqApplicationTests {

    @Autowired
    private QueueProducer queueProducer;
    @Autowired
    private TopicProducer topicProducer;

    @Test
    void sendMessage() {
        queueProducer.sendQueue();
    }

    @Test
    void receiveMessage() {
        //topicProducer.sendTopic();
    }

}
