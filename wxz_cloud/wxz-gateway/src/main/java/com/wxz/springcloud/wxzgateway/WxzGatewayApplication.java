package com.wxz.springcloud.wxzgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class WxzGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxzGatewayApplication.class, args);
    }

}
