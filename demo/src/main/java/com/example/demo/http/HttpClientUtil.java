package com.example.demo.http;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.util.Base64Utils;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class HttpClientUtil {

    private static PoolingHttpClientConnectionManager cm;
    private static String EMPTY_STR = "";
    private static String UTF_8 = "UTF-8";

    private static void init() {
        if (cm == null) {
            cm = new PoolingHttpClientConnectionManager();
            // 整个连接池最大连接数
            cm.setMaxTotal(50);
            // 每路由最大连接数，默认值是2
            cm.setDefaultMaxPerRoute(5);
        }
    }

    /**
     * 通过连接池获取HttpClient
     *
     * @return
     */
    private static CloseableHttpClient getHttpClient() {
        init();
        return HttpClients.custom().setConnectionManager(cm).build();
    }

    public static String httpPostRequestByJson(String url, String json) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).setConnectionRequestTimeout(30000).setSocketTimeout(30000).build();
        httpPost.setConfig(requestConfig);
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-type", "application/json; charset=utf-8");
        httpPost.setHeader("Accept", "application/json");
        httpPost.setEntity(new StringEntity(json, Charset.forName("UTF-8")));
        String result = getResult(httpPost);
        return result;
    }

    public static String httpPostRequestByJson(String url, String json,Map<String,Object> headers) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).setConnectionRequestTimeout(30000).setSocketTimeout(30000).build();
        httpPost.setConfig(requestConfig);
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-type", "application/json; charset=utf-8");
        httpPost.setHeader("Accept", "application/json");
        for (Map.Entry<String, Object> param : headers.entrySet()) {
            httpPost.addHeader(param.getKey(), String.valueOf(param.getValue()));
        }
        httpPost.setEntity(new StringEntity(json, Charset.forName("UTF-8")));
        String result = getResult(httpPost);
        return result;
    }


    /**
     * 处理Http请求
     */
    private static String getResult(HttpRequestBase request) {

        // CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpClient httpClient = getHttpClient();
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            // response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // long len = entity.getContentLength();// -1 表示长度未知
                String result = EntityUtils.toString(entity, "utf-8").trim();
                response.close();
                // httpClient.close();
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EMPTY_STR;
    }

    /**
     * 处理Http请求
     */
    private static InputStream getResultStream(HttpRequestBase request) {
        InputStream inputStream = null;
        CloseableHttpClient httpClient = getHttpClient();
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return entity.getContent();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;
    }


    public static void main(String[] args) {
//        String ss = parseUrl("http://ennvmppre.enn.cn:8000/proxy.jsp?ennproject_proxy/ServiceEngine/rest/ennProjectService/getHSJDByPro?&proid=112922&type=2&userid=13597&token=cuha0WKXH9BooYeWpIgKq9I1pusOAPdbL56yNe7TQcxbJK2gmA0Pe6rr1UUbMgmmsyiscHP3nh8...-_");
//        System.out.println(ss);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tagtype","1");
        JSONArray userIdArray = new JSONArray();
        userIdArray.add("10000005");
        jsonObject.put("userid",userIdArray);
        try {
            String r =  httpPostRequestByJson("http://10.37.147.238:8082/label/gettag",jsonObject.toJSONString());
            System.out.println("-----"+r);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }



}
