package com.wxz.mqapplication.controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RabbitMQController {

//    @Resource(name="myRabbitTemplate")
//    private RabbitTemplate rabbitTemplate;
//
//    @GetMapping(path = "publish")
//    public boolean publish(String data) {
//        rabbitTemplate.convertAndSend("topicExchange", "topic.mess2", data);
//        return true;
//    }

    @RabbitListener(queues = "",containerFactory = "myFactory")
    public void consumerExistsQueue(String data) {
        System.out.println("--------");
        System.out.println("consumerExistsQueue: " + data);
    }

}
