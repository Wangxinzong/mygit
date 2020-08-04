package com.wxz.springcloud.wxz_cloud_consumer;

import com.wxz.springcloud.wxz_cloud_common.entity.User;
import com.wxz.springcloud.wxz_cloud_consumer.controller.ConsumerController;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.asciidoctor.cli.AsciidoctorInvoker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.nio.file.Paths;

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

    @Test
    public void generateAsciiDocs() throws Exception {
        //    输出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withGeneratedExamples()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .build();
        //http://127.0.0.1:9002/swagger-ui.html
        //http://localhost:8080/v2/api-docs
        Swagger2MarkupConverter.from(new URL("http://127.0.0.1:9002/swagger-ui.html"))
                .withConfig(config)
                .build()
                .toFile(Paths.get("src/docs/asciidoc/generated/api"));
    }
    @Test
    public void generatePDF() {
        //样式
        String style = "pdf-style=E:\\themes\\theme.yml";
        //字体
        String fontsdir = "pdf-fontsdir=E:\\fonts";
        //需要指定adoc文件位置
        String adocPath = "E:\\all.adoc";
        AsciidoctorInvoker.main(new String[]{"-a",style,"-a",fontsdir,"-b","pdf",adocPath});
    }

}
