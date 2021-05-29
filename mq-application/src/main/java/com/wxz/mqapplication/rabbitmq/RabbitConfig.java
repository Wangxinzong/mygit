package com.wxz.mqapplication.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitConfig {
    private String host = "10.39.71.243";
    private int port =5672;
    private String username = "enn_stock";
    private String password = "enn_stock123456";
    private String virtualHost = "project_digital";

//    @Bean(name = "myConnectionFactory")
//    @Primary
//    public ConnectionFactory myConnectionFactory(
//            @Value("${spring.rabbitmq.first.host}") String host,
//            @Value("${spring.rabbitmq.first.port}") int port,
//            @Value("${spring.rabbitmq.first.username}") String username,
//            @Value("${spring.rabbitmq.first.password}") String password
//    ) {
//        return connectionFactory(host, port, username, password);
//    }

    @Bean(name = "myConnectionFactory")
    public ConnectionFactory myConnectionFactory() {
        return connectionFactory(host, port, username, password,virtualHost);
    }

    public CachingConnectionFactory connectionFactory(String host, int port, String username, String password){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }

    public CachingConnectionFactory connectionFactory(String host, int port, String username, String password,String virtualHost){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        return connectionFactory;
    }

//    @Bean(name = "myRabbitTemplate")
//    public RabbitTemplate myRabbitTemplate(
//            @Qualifier("myConnectionFactory") ConnectionFactory connectionFactory
//    ) {
//        RabbitTemplate myRabbitTemplate = new RabbitTemplate(connectionFactory);
//        return myRabbitTemplate;
//    }

    @Bean(name = "myFactory")
    @Primary
    public SimpleRabbitListenerContainerFactory myFactory(
            SimpleRabbitListenerContainerFactoryConfigurer configurer,
            @Qualifier("myConnectionFactory") ConnectionFactory connectionFactory
    ) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    /*
    声明交换机 amq.topic topic类型的，其他类型的直接改TopicExchange
     */
//    @Bean
//    public TopicExchange basicExchange(){
//        return new TopicExchange("topicExchange", true,false);
//    }

    /*
    声明消息队列 启动创建，停止自动删除
     */
//    @Bean(name = "basicQueue")
//    public Queue basicQueue(){
//        return new Queue("acquire-alarm-volume", false,false,true);
//    }

    /*
    队列绑定交换机 *.*.*.*.*.*为rountingkey
     */
//    @Bean
//    public Binding basicBinding(){
//        return BindingBuilder.bind(basicQueue()).to(basicExchange()).with("topic.*");}
}
