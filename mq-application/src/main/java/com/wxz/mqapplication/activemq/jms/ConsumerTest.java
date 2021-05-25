package com.wxz.mqapplication.activemq.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ConsumerTest {
    //private String DEFAULT_BROKER_URL = "tcp://10.1.169.52:61616";
    private String DEFAULT_BROKER_URL = "tcp://192.168.43.111:61616";
    private String DEFAULT_USER = "admin";
    private String DEFAULT_PASSWORD = "admin";
    private ActiveMQConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private MessageConsumer consumer;

    public static void main(String[] args) {
        ConsumerTest ct = new ConsumerTest();
        try {
            ct.consumer();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void consumer() throws JMSException {
        try {
            connectionFactory = new ActiveMQConnectionFactory(DEFAULT_BROKER_URL);
            connection = connectionFactory.createConnection(DEFAULT_USER, DEFAULT_PASSWORD);
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("queue1");
            consumer = session.createConsumer(queue);
            while (true) {
                TextMessage textMessage = (TextMessage) consumer.receive();
                if (textMessage != null) {
                    System.out.println("接收消息:" + textMessage.getText());
                } else {
                    return;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            consumer.close();
            session.close();
            connection.close();
        }

    }
}
