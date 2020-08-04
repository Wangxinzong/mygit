package com.wxz.personal.myproject.qingcloud;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qingstor.sdk.config.EvnContext;
import com.qingstor.sdk.exception.QSException;
import com.qingstor.sdk.service.Bucket;
import com.qingstor.sdk.service.QingStor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

public class QingCloudExample2 {

    private final static Logger LOGGER = LoggerFactory.getLogger(QingCloudExample2.class);

    public static void main(String[] args) {
        String result = null;
        String bucketName = "{\"bucketName\":\"ouyangjun2\"}";
        String bucketObjectName = "{\"bucketName\":\"ouyangjun2\",\"objectName\":\"zjg.jpg\"}";
        QingCloudExample2 example2 = new QingCloudExample2();
        result = example2.createObject(bucketName);
        System.out.println(result);

    }

    /**
     * 青云-获取Bucket列表
     * Bucket:存储空间
     */
    public String listBuckets() {
        try {
            // 获取QingStor对象
            QingStor qingstor = QingStorUtils.getQingStorSingleton();

            // 获取Bucket列表
            QingStor.ListBucketsOutput listOutput = qingstor.listBuckets(null);

            // 转换成json字符串
            String buckets = JSON.toJSONString(listOutput);
            LOGGER.info("Bucket列表: {}", buckets);

            // 返回值
            return buckets;
        } catch (QSException e) {
            LOGGER.info("/listBuckets,获取Bucket列表失败!", e);
        }
        return "List Bucket Error!";
    }


    /**
     * 青云-创建Bucket
     * 请求地址: http://localhost:8080/qingstor/createBucket
     * 参数: {
     * "bucketName":"ouyangjun"
     * }
     *
     * @return
     */
    public String createBucket(String objJson) {
        LOGGER.info("/createBucket,objJson: {}", objJson);
        if (StringUtils.isEmpty(objJson)) {
            return "objJson is null!";
        }
        try {
            LOGGER.info("/createBucket,创建Bucket步骤-----begin-----");
            // 解析对象
            JSONObject obj = JSONObject.parseObject(objJson);
            if (obj != null && !StringUtils.isEmpty(obj.get("bucketName"))) {
                // 获取对象
                QingStor qingstor = QingStorUtils.getQingStorSingleton();
                // 构建Bucket对象
                Bucket bucket = qingstor.getBucket(String.valueOf(obj.get("bucketName")), QingStorUtils.myZone);
                //创建Bucket
                Bucket.PutBucketOutput putBucketOutput = bucket.put();

                LOGGER.info("/createBucket,创建Bucket步骤-----end-----");
                return JSONObject.toJSONString(putBucketOutput);
            }

        } catch (QSException e) {
            LOGGER.info("/createBucket,创建Bucket失败!", e);
        }
        return "Create Bucket Error!";
    }

    /**
     * 青云-删除Bucket
     * 请求地址: http://localhost:8080/qingstor/deleteBucket
     * 参数: {
     * "bucketName":"ouyangjun"
     * }
     *
     * @return
     */
    public String deleteBucket(String objJson) {
        LOGGER.info("/deleteBucket,objJson: {}", objJson);
        if (StringUtils.isEmpty(objJson)) {
            return "objJson is null!";
        }
        try {
            LOGGER.info("/deleteBucket,删除Bucket步骤-----begin-----");
            // 解析对象
            JSONObject obj = JSONObject.parseObject(objJson);
            if (obj != null && !StringUtils.isEmpty(obj.get("bucketName"))) {
                // 获取对象
                QingStor qingstor = QingStorUtils.getQingStorSingleton();
                //构建Bucket对象
                Bucket bucket = qingstor.getBucket(String.valueOf(obj.get("bucketName")), QingStorUtils.myZone);
                // 删除bucket对象
                Bucket.DeleteBucketOutput deleteBucketOutput = bucket.delete();

                LOGGER.info("/deleteBucket,删除Bucket步骤-----end-----");
                return JSONObject.toJSONString(deleteBucketOutput);
            }

        } catch (QSException e) {
            LOGGER.info("/createBucket,创建Bucket失败!", e);
        }
        return "Create Bucket Error!";
    }


    /**
     * 获取Bucket中存储的Object列表
     * 请求地址: http://localhost:8080/qingstor/listObjects
     * 参数: {
     * "bucketName":"ouyangjun"
     * }
     */
    public String listObjects(String objJson) {
        LOGGER.info("/listObjects,objJson: {}", objJson);
        if (StringUtils.isEmpty(objJson)) {
            return "objJson is null!";
        }
        try {
            LOGGER.info("/listObjects,获取Bucket Object-----begin-----");
            // 解析对象
            JSONObject obj = JSONObject.parseObject(objJson);
            if (obj != null && !StringUtils.isEmpty(obj.get("bucketName"))) {
                // 获取QingStor对象
                QingStor qingstor = QingStorUtils.getQingStorSingleton();
                // 获取Bucket对象
                Bucket bucket = qingstor.getBucket(String.valueOf(obj.get("bucketName")), QingStorUtils.myZone);
                // 获取Object对象列表
                Bucket.ListObjectsOutput listOutput = bucket.listObjects(null);

                LOGGER.info("/listObjects,获取Bucket Object-----end-----");
                return JSON.toJSONString(listOutput);
            }
        } catch (QSException e) {
            LOGGER.info("/listObjects,获取Bucket Object列表失败!", e);
        }
        return "List Object Error!";
    }

    /**
     * 删除Bucket中存储的Object列表
     * 请求地址: http://localhost:8080/qingstor/deleteObject
     * 参数: {
     * "bucketName":"ouyangjun",
     * "objectName":""
     * }
     */
    public String deleteObject(String objJson) {
        LOGGER.info("/deleteObject,objJson: {}", objJson);
        if (StringUtils.isEmpty(objJson)) {
            return "objJson is null!";
        }
        try {
            LOGGER.info("/deleteObject,删除Bucket Object-----begin-----");
            // 解析对象
            JSONObject obj = JSONObject.parseObject(objJson);
            if (obj != null && !StringUtils.isEmpty(obj.get("bucketName"))) {
                // 获取QingStor对象
                QingStor qingstor = QingStorUtils.getQingStorSingleton();

                // 获取Bucket对象
                Bucket bucket = qingstor.getBucket(String.valueOf(obj.get("bucketName")), QingStorUtils.myZone);

                // 判断文件名称是否为空
                if (!StringUtils.isEmpty(obj.get("objectName"))) {
                    // 获取Object对象(名称是唯一的,不能重复,如果文件不存在,删除就没效果)
                    Bucket.DeleteObjectOutput deleteOutput = bucket.deleteObject(String.valueOf(obj.get("objectName")));

                    LOGGER.info("/deleteObject,删除Bucket Object-----end-----");
                    return JSON.toJSONString(deleteOutput);
                }
            }
        } catch (QSException e) {
            LOGGER.info("/deleteObject,删除Bucket Object失败!", e);
        }
        return "Delete Object Error!";
    }

    /**
     * 在指定Bucket下创建一个Object对象
     * 请求地址: http://localhost:8080/qingstor/createObject
     * 参数: {
     * "bucketName":"ouyangjun"
     * }
     */
    public String createObject(String objJson) {
        LOGGER.info("/createObject,objJson: {}", objJson);
        if (StringUtils.isEmpty(objJson)) {
            return "objJson is null!";
        }
        try {
            LOGGER.info("/createObject,创建Bucket Object-----begin-----");
            // 解析对象
            JSONObject obj = JSONObject.parseObject(objJson);
            if (obj != null && !StringUtils.isEmpty(obj.get("bucketName"))) {
                // 文件路径
                String fileUrl = "D:\\Picture\\zjg.jpg";
                File file = new File(fileUrl);
                if (!file.exists()) {
                    return fileUrl + " is not exists!";
                }

                // 获取QingStor对象
                QingStor qingstor = QingStorUtils.getQingStorSingleton();

                // 获取Bucket对象
                Bucket bucket = qingstor.getBucket(String.valueOf(obj.get("bucketName")), QingStorUtils.myZone);

                // 创建对象
                Bucket.PutObjectInput input = new Bucket.PutObjectInput();
                input.setBodyInputFile(file);
                String contentType = Files.probeContentType(Paths.get(fileUrl));
                input.setContentType(contentType);
                input.setContentLength(file.length());
                Bucket.PutObjectOutput putObjectOutput = bucket.putObject("clys2/" + file.getName(), input);
                if (putObjectOutput.getStatueCode() == 201) {
                    long expiration = System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10;
                    String saveUrl = bucket.GetObjectBySignatureUrlRequest(file.getName(), null, expiration).getExpiresRequestUrl();
                    System.out.println(saveUrl);
                }
                LOGGER.info("/createObject,创建Bucket Object-----end-----");
                return JSON.toJSONString(putObjectOutput);
            }
        } catch (QSException e) {
            LOGGER.info("/createObject,创建Bucket Object失败!", e);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.info("/createObject,获取文件content-type类型失败", e);
        }
        return "Create Object Error!";
    }

    /**
     * 查询青云QingStor文件,可以转换成流
     *
     * @param objJson 请求地址: http://localhost:8080/qingstor/getObjectByFileName
     *                参数: {
     *                "bucketName":"ouyangjun",
     *                "objectName":"oyj.txt"
     *                }
     */
    public String getFileByte(String objJson) {
        LOGGER.info("/getObjectByFileName,objJson: {}", objJson);
        if (StringUtils.isEmpty(objJson)) {
            return "objJson is null!";
        }

        try {
            // 解析对象
            JSONObject obj = JSONObject.parseObject(objJson);
            if (obj != null && !StringUtils.isEmpty(obj.get("bucketName"))) {
                // 获取QingStor对象
                QingStor qingstor = QingStorUtils.getQingStorSingleton();

                Bucket bucket = qingstor.getBucket(String.valueOf(obj.get("bucketName")), QingStorUtils.myZone);

                Bucket.GetObjectInput headObjectInput = new Bucket.GetObjectInput();
                Bucket.GetObjectOutput out = bucket.getObject(String.valueOf(obj.get("objectName")), headObjectInput);

                if (HttpStatus.OK.value() == out.getStatueCode()) {
                    if (Objects.nonNull(out.getBodyInputStream())) {
                        // org.apache.commons.io.IOUtils.toByteArray(out.getBodyInputStream());
                        LOGGER.info("BodyInputStream: {}", out.getBodyInputStream());
                        return "true";
                    }
                }
            }

        } catch (QSException e) {
            LOGGER.error("[青云Qingstor文件获取失败]", e);
        }
        return "false";
    }

    static class QingStorUtils {

        private final static Logger LOGGER = LoggerFactory.getLogger(QingStorUtils.class);

        // 北京3区
        public final static String myZone = "pek3b";
        // qy_access_key_id
        private final static String myAccessKeyId = "DBNQFKYISQYWMSGZYGHU";
        // qy_secret_access_key
        private final static String mySecretAccessKey = "HHY0M1xmkgHyForuxFcP8My10JXAjNSCT1gQ0RK6";
        ;

        private static class QingStorService {
            // 获取对象
            private static QingStor qingStor = getQingStor();

            private static QingStor getQingStor() {
                EvnContext evn = new EvnContext(myAccessKeyId, mySecretAccessKey);
                QingStor storService = new QingStor(evn, myZone);
                // 返回
                return storService;
            }
        }

        /**
         * 构建QingStor对象
         *
         * @return
         */
        public static QingStor getQingStorSingleton() {
            return QingStorService.qingStor;
        }

    }


}
