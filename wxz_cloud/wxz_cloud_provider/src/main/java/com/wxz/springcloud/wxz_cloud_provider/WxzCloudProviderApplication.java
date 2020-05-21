package com.wxz.springcloud.wxz_cloud_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WxzCloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxzCloudProviderApplication.class, args);
    }

}
