package com.wxz.springcloud.wxz_cloud_provider.controller;

import com.wxz.springcloud.wxz_cloud_common.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProviderController {

    private List<User> userList = new ArrayList<>();

    @PostMapping(value = "add")
    public User insertUser(@RequestBody User user) {
        userList.add(user);
        System.out.println("添加成功:" + userList.size());
        return user;
    }

    @GetMapping(value = "add/form")
    public User addUser(@RequestParam User user) {
        System.out.println("+++++:" + user.toString());
        userList.add(user);
        System.out.println("添加成功:" + userList.size());
        return user;
    }

    @GetMapping(value = "findById")
    public User getUser(@RequestParam("id") Integer id) {
        User user = userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst().get();
        return user;
    }

    @GetMapping(value = "findById/{id}")
    public User getUser(@PathVariable("id") String id) {
        User user = userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst().get();
        return user;
    }

    @PostMapping(value = "findAll")
    public List<User> findAll(Integer pageSize) {
        System.out.println("-----" + pageSize);
        List<User> resultList = userList.stream()
                .limit(pageSize)
                .collect(Collectors.toList());
        return resultList;
    }

    @GetMapping(value = "findByIds")
    public List<User> findByIds(@RequestParam Integer[] ids) {
        System.out.println("====:" + ids.toString());
        return null;
    }

    @GetMapping(value = "stream")
    public void stream(HttpServletResponse response){
        OutputStream outStream;
        try {
            File file = new File("D:\\工作表.xlsx");
            InputStream fileInputStream = new FileInputStream(file);
            outStream = response.getOutputStream();

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1) {
                outStream.write(bytes, 0, len);
            }
            fileInputStream.close();
            outStream.close();
            outStream.flush();
        } catch (IOException e) {

        }
    }


}
