package com.wxz.springcloud.wxz_cloud_consumer.controller;

import com.wxz.springcloud.wxz_cloud_common.entity.User;
import com.wxz.springcloud.wxz_cloud_consumer.controller.api.PrividerApi;
import feign.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("feign")
@Api(description = "微服务调用")
public class FeignConsumerController {

    @Autowired
    private PrividerApi prividerApi;

    @PostMapping("/addUser")
    @ApiOperation(value = "添加用户")
    public User insertUser(@RequestBody User user) {
        return prividerApi.insertUser(user);
    }

    @GetMapping("/addUser/form")
    public User addUser(User user) {
        System.out.println(user.toString());
        //这样调用有问题
        //return prividerApi.addUser(user);
        return prividerApi.insertUser(user);
    }

    @PostMapping(value = "/findAll")
    @ApiImplicitParam(paramType = "query", name = "pageSize", value = "条数", dataType = "int")
    public List<User> findAll(Integer pageSize) {
        System.out.println(pageSize);
        return prividerApi.findAll(pageSize);
    }

    @GetMapping("/findByIds")
    public List<User> findByIds(@RequestParam Integer[] ids) {
        System.out.println("=====:" + ids);
        System.out.println("consumer----:" + ids.length);
        prividerApi.findByIds(ids);
        return null;
    }

    @GetMapping("/stream")
    public void stream(HttpServletResponse servletResponse){
        Response response = prividerApi.stream();
        Response.Body body = response.body();
        InputStream fileInputStream = null;
        OutputStream outStream;
        try {
            fileInputStream = body.asInputStream();
            outStream = servletResponse.getOutputStream();

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                outStream.write(bytes, 0, len);
            }
            fileInputStream.close();
            outStream.close();
            outStream.flush();
        } catch (Exception e) {

        }
    }
}
