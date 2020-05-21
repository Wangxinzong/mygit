package com.wxz.springcloud.wxz_cloud_consumer;

import com.wxz.springcloud.wxz_cloud_common.entity.User;
import com.wxz.springcloud.wxz_cloud_consumer.controller.ConsumerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WxzCloudConsumerApplicationTests {

    @Autowired
    private ConsumerController consumerController;

    @Test
    void text1() {
        User user = new User();
        user.setId(2);
        user.setName("李四");
        user.setAddress("廊坊");
        user.setSalary(15000d);
        consumerController.insertUser(user);
    }

}
