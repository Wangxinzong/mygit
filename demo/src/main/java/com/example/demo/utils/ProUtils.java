package com.example.demo.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProUtils {

    private static ProUtils instance;
    private static final String SPECIAL_USER_CODE_KEY = "special_user_code_key";

    private ProUtils() {
    }

    public static ProUtils getInstance() {
        if (null == instance) {
            instance = new ProUtils();
        }
        return instance;
    }

    /* 图片转base64字符串
     * @param imgFile 图片路径
     * @return base64字符串格式的图片
     */
    public String fileToBase64Str(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];  //根据文件流字节大小初始化data字节数组大小
            inputStream.read(data);  //将流读入data
            inputStream.close();  //关闭流
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            //关闭流
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return Base64.getEncoder().encodeToString(data);
    }


    /**
     * 将base64字符串转成图片
     * TODO
     *
     * @param imgStr base64图片字符串
     * @return
     */
    public InputStream base64StrToFileStream(String imgStr) {
        if (imgStr == null)
            return null;

        ByteArrayInputStream in = null;
        try {
            // 解密base64图片字符串
            byte[] b = Base64.getDecoder().decode(imgStr);
            // 调整异常数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            //转化为输入流
            in = new ByteArrayInputStream(b);
            File tempFile = new File("D:\\IdeaProject\\ab.pdf");
            //文件夹不存在则自动创建
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(tempFile);
            out.write(b);
            out.flush();
            out.close();
            //return true;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return in;
    }

    /* 图片转base64字符串
     * @param imgFile 图片路径
     * @return base64字符串格式的图片
     */
    public String fileToBase64EncoderStr(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];  //根据文件流字节大小初始化data字节数组大小
            inputStream.read(data);  //将流读入data
            inputStream.close();  //关闭流
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            //关闭流
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return new BASE64Encoder().encodeBuffer(data);
    }

    /**
     * 将base64字符串转成图片
     * TODO
     *
     * @param imgStr base64图片字符串
     * @return
     */
    public void base64DecoderStrToFileStream(String imgStr) {
        if (imgStr == null)
            return ;

        ByteArrayInputStream in = null;
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();

            // 解密base64图片字符串
            //byte[] b = Base64.getDecoder().decode(imgStr);
            byte[] b = base64Decoder.decodeBuffer(imgStr);
            // 调整异常数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            //转化为输入流
            in = new ByteArrayInputStream(b);
            File tempFile = new File("D:\\IdeaProject\\a.pdf");
            //文件夹不存在则自动创建
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(tempFile);
            out.write(b);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


}
