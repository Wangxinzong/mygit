package com.wxz.personal.myproject.controller;

import com.alibaba.fastjson.JSON;
import com.wxz.personal.myproject.response.BaseResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class LoginController {

    @RequestMapping("test")
    public BaseResponse test(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("test接口返回成功");
        return baseResponse;
    }



}
