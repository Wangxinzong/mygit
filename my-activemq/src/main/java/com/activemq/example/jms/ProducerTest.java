package com.activemq.example.jms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.messaging.Message;
import org.springframework.messaging.core.MessagePostProcessor;

import javax.jms.*;
import java.util.HashMap;

public class ProducerTest {

    //private String DEFAULT_BROKER_URL = "tcp://10.1.169.52:61616";
    private String DEFAULT_BROKER_URL = "tcp://192.168.43.111:61616";
    private String DEFAULT_USER = "admin";
    private String DEFAULT_PASSWORD = "admin";
    private ActiveMQConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private MessageProducer producer;

    public static void main(String[] args){
        ProducerTest pt = new ProducerTest();
        try {
            pt.connection();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void connection() throws JMSException {
        try {
            connectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_URL);
            connection = connectionFactory.createConnection(DEFAULT_USER,DEFAULT_PASSWORD);
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("queue1");
            producer = session.createProducer(queue);
            TextMessage message = session.createTextMessage();
            for(int i=11;i<14;i++){
                message.setText("0"+i);
                producer.send(message);
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            producer.close();
            session.commit();
            session.close();
            connection.close();
        }

    }

}
