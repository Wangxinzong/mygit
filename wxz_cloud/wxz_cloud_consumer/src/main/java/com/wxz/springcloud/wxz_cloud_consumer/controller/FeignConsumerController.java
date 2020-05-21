package com.wxz.springcloud.wxz_cloud_consumer.controller;

import com.wxz.springcloud.wxz_cloud_common.entity.User;
import com.wxz.springcloud.wxz_cloud_consumer.controller.api.PrividerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("feign")
public class FeignConsumerController {

    @Autowired
    private PrividerApi prividerApi;

    @PostMapping("/addUser")
    public User insertUser(@RequestBody  User user){
        return prividerApi.insertUser(user);
    }

    @GetMapping("/addUser/form")
    public User addUser( User user){
        System.out.println(user.toString());
        //这样调用有问题
        //return prividerApi.addUser(user);
        return prividerApi.insertUser(user);
    }

    @PostMapping(value = "/findAll")
    public List<User> findAll(Integer pageSize){
        System.out.println(pageSize);
        return  prividerApi.findAll(pageSize);
    }

    @GetMapping("/findByIds")
    public List<User> findByIds(@RequestParam Integer[] ids){
        System.out.println("=====:"+ids);
        System.out.println("consumer----:"+ids.length);
        prividerApi.findByIds(ids);
        return null;
    }
}
