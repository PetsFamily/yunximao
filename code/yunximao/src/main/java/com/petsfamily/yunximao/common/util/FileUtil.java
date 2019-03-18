package com.petsfamily.yunximao.common.util;

import java.io.File;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
@Component
public class FileUtil {
	@Value("${aliyun.Endpoint}")
	private String endpoint;
	@Value("${aliyun.AccessKeyID}")
	private String accessKeyId;
	@Value("${aliyun.AccessKeySecret}")
	private String accessKeySecret;
	@Value("${aliyun.BucketName}")
	private String bucketName;
		
	public String saveByAliOSS(String fileName, InputStream in) {
		OSSClient ossClient = new OSSClient("http://"+endpoint, accessKeyId, accessKeySecret);
		ossClient.putObject(bucketName,fileName,in);
		ossClient.shutdown();
		return "https://"+bucketName+"."+endpoint+"/"+fileName;
	}
	
	public File getByAliOSS(String fileName) {
		try {
			File file = File.createTempFile(fileName.split("\\.")[0],fileName.split("\\.")[1]);
			// 创建OSSClient实例。
			OSSClient ossClient = new OSSClient("http://"+endpoint, accessKeyId, accessKeySecret);
			// 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
			ossClient.getObject(new GetObjectRequest(bucketName,fileName),file);
			// 关闭OSSClient。
			ossClient.shutdown();
			return file;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
}
