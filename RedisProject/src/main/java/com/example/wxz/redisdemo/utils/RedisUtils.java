package com.example.wxz.redisdemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;


    public Object get(Object key){
        return redisTemplate.opsForValue().get(key);
    }

    public void put(Object key,Object value){
        redisTemplate.opsForValue().set(key,value);
    }


}
