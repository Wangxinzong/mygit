package com.example.demo.utils;

import com.example.demo.Model;
import com.example.demo.Student;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

    private static ThreadLocal<String> TIMER_START = new ThreadLocal<String>();

    public static void main(String[] args){
//        try {
//        String filePath = "D:\\IdeaProject\\施工方案文档模板.pdf";
//        String fileBase64 = ProUtils.getInstance().fileToBase64Str(filePath);
//        String imgPath = "D:\\Pictures\\mahaonan.PNG";
//        String imgBase64 = ProUtils.getInstance().fileToBase64Str(imgPath);
//        InputStream inputStream = SignatureUtils.getInstance().signPerson(fileBase64,imgBase64);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

           List<Model> list = new ArrayList<>();
          Model model = new Model("0");
        Model model2 = new Model("0");
        list.add(model);
        list.add(model2);
        Student student = new Student();
        student.setList(list);
        List<Model> list2 = student.getList();
        for(Model m:list2){
            m.setStatus("1");
        }
        //输出
        List<Model> modelList = student.getList();
        for(Model model1:modelList){
            System.out.println(model1.getStatus());
        }

    }



}
