package com.example.demo.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.http.HttpClientUtil;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class SignatureUtils {

    private static SignatureUtils instance;
    private String signPerson = "http://dzqz-hr-test-api.imepaas.enncloud.cn/dzqz-hr-api/contract/signing/person";
    private String appKey = "F2BViGifI3nClpvpAor1pvow7lfRJ5YZ";

    private SignatureUtils() {

    }

    public static SignatureUtils getInstance() {
        if (null == instance) {
            instance = new SignatureUtils();
        }
        return instance;
    }

    /**
     * 个人手写字签名按关键
     *
     * @param fileName       文件名称
     * @param fileBase64     文件的base64编码
     * @param isPreserve     是否保全
     * @param name           姓名
     * @param cardNum        身份证号
     * @param mobile         手机号
     * @param imgBase64      签名图片的base64编码
     * @param imgWidth       手写图片宽度，默认为0图片实际宽度大小
     * @param imgHeight      手写图片高度，默认为0图片实际高度大小
     * @param keyword        关键字
     * @param keywordType    关键字类型, 0 为所有关键字， 1 为单个关键字
     * @param coverType      印章覆盖类型， 覆盖类型， 1: 重叠、 2: 居下、 3: 居右
     * @param widthMoveSize  关键字定位后宽度偏移（整数）
     * @param heightMoveSize 关键字定位后高度偏移（整数）
     */
    public InputStream signPerson(String fileBase64, String imgBase64) throws UnsupportedEncodingException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fileName", "测试文件名");
        jsonObject.put("fileBase64", fileBase64);
        jsonObject.put("isPreserve", "0");
        //个人信息
        JSONObject personJsonObject = new JSONObject();
        personJsonObject.put("name", "王冰");
        personJsonObject.put("cardNum", "150981197202284550");
        personJsonObject.put("mobile", "15136305592");
        personJsonObject.put("imgBase64", imgBase64);
        personJsonObject.put("imgWidth", 100);
        personJsonObject.put("imgHeight", 50);
        jsonObject.put("person", personJsonObject);
        //关键字信息
        JSONObject keyWordObject = new JSONObject();
        keyWordObject.put("keyword", "编制：");
        keyWordObject.put("keywordType", "1");
        keyWordObject.put("coverType", "3");
        keyWordObject.put("widthMoveSize", 0);
        keyWordObject.put("heightMoveSize", 0);
        jsonObject.put("keywordInfo", keyWordObject);


        Map<String, Object> headers = new HashMap<>();
        headers.put("appKey", appKey);
        headers.put("appSecret", appKey);
        String centerResponse = HttpClientUtil.httpPostRequestByJson(signPerson, jsonObject.toJSONString(), headers);

        JSONObject resultJson = JSON.parseObject(centerResponse);
        if("-1".equals(resultJson.getString("code"))){
            System.out.println(resultJson.getString("msg"));
            return null;
        }
        String resFileBase64 = resultJson.getString("fileBase64");
        if(null==resFileBase64 || "".equals(resFileBase64)){
            System.out.println("手写签章接口返回空");
            return null;
        }
        InputStream inputStream = ProUtils.getInstance().base64StrToFileStream(resFileBase64);
        return inputStream;
    }

}
