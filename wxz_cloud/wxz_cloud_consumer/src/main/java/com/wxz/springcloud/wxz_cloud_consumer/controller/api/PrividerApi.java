package com.wxz.springcloud.wxz_cloud_consumer.controller.api;

import com.wxz.springcloud.wxz_cloud_common.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "cloud-provider")
public interface PrividerApi {

    @PostMapping(value = "add")
    public User insertUser(@RequestBody User user);

    @GetMapping(value = "add/form")
    public User addUser(@RequestParam User user);

    @PostMapping(value = "findAll")
    public List<User> findAll(@RequestParam("pageSize") Integer pageSize);

    @GetMapping(value = "findByIds")
    public List<User> findByIds(@RequestParam Integer[] ids);
}
