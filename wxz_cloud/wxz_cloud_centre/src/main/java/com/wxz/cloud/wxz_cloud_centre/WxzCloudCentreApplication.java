package com.wxz.cloud.wxz_cloud_centre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class WxzCloudCentreApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxzCloudCentreApplication.class, args);
    }

}
