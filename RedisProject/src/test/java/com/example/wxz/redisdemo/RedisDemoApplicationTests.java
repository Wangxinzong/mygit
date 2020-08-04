package com.example.wxz.redisdemo;

import com.alibaba.fastjson.JSON;
import com.example.wxz.redisdemo.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisDemoApplicationTests {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    void set() {
//        Goods goods = new Goods();
//        goods.setId(1);
//        goods.setName("测试商品");
//        redisUtils.put("{GOODS}_1",goods);
    }

    @Test
    void get() {
        Object obj = redisUtils.get("{GOODS}_819");
        if(obj!=null){
            String result = JSON.toJSONString(obj);
            System.out.println(result);
        }

    }

}
