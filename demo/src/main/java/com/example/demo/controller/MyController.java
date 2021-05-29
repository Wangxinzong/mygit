package com.example.demo.controller;

import com.example.demo.Student;
import com.example.demo.service.MySqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MyController {

    @Autowired
    private MySqlService mySqlService;

    @RequestMapping("method1")
    public String method1(){
        return "成功";
    }

    @RequestMapping("insert")
    public int insertStudent(){
        Student student = new Student();
        student.setName("张山");
        student.setAge(34);
        student.setSex(0);
        return mySqlService.insert(student);
    }

    @RequestMapping("queryAll")
    public List<Map<String,Object>> selectStudentAll(){
        return mySqlService.selectAll();
    }


}
