package com.example.demo.utils;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class MainTest {

    public static void main(String[] args){
        try {
        String filePath = "D:\\IdeaProject\\施工方案文档模板.pdf";
        String fileBase64 = ProUtils.getInstance().fileToBase64Str(filePath);
        String imgPath = "D:\\Pictures\\qianming.PNG";
        String imgBase64 = ProUtils.getInstance().fileToBase64Str(imgPath);
        InputStream inputStream = SignatureUtils.getInstance().signPerson(fileBase64,imgBase64);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
