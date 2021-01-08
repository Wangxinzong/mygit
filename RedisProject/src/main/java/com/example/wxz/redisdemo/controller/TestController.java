package com.example.wxz.redisdemo.controller;

import com.example.wxz.redisdemo.service.RedisClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    RedisClientTemplate redisClientTemplate;

    @GetMapping(value = "/testSet")
    public Object testSet(){
        redisClientTemplate.setToRedis("Frank","Frank测试redis");
        System.out.println(redisClientTemplate.getRedis("Frank"));
        return null;
    }

    @GetMapping(value = "/deleteKey")
    public void deleteKey(@RequestParam("key") String key){
        Long res = redisClientTemplate.deleteRedis(key);
        System.out.println("删除:"+res);
    }
}
