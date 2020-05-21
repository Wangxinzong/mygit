package com.wxz.springcloud.wxz_cloud_consumer.controller;

import com.wxz.springcloud.wxz_cloud_common.entity.User;
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
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("getUser")
    public User gethelloConsumer(){
        User user = null;
        // user = restTemplate.getForEntity("http://CLOUD-PROVIDER/findById?id={1}", User.class,1).getBody();

        Map<String,Integer> map = new HashMap<>();
        map.put("id",2);
       user =  restTemplate.getForEntity("http://CLOUD-PROVIDER/findById?id={id}", User.class,map).getBody();
        return  user;
    }

    @PostMapping("addUser")
    public User insertUser(@RequestBody  User user){
        return restTemplate.postForEntity("http://CLOUD-PROVIDER/add", user,User.class).getBody();
    }

    @GetMapping("getAll")
    public List<User> getAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("pageSize", "10");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        return restTemplate.postForEntity("http://CLOUD-PROVIDER/findAll",request,List.class).getBody();
    }
}
