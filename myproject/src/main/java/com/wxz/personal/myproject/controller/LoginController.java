package com.wxz.personal.myproject.controller;

import com.alibaba.fastjson.JSON;
import com.wxz.personal.myproject.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@PropertySource(value = {"my.properties"})
public class LoginController {

//    @Value("${my.name}")
//    private String author;
//    @Value("${my.age}")
//    private String name;

    @Autowired
    private User user;

    @RequestMapping("test")
    public BaseResponse test(){
        System.out.println(user.toString());
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("test接口返回成功");
        return baseResponse;
    }



}
