package com.petsfamily.yunximao.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.green.model.v20180509.ImageSyncScanRequest;
import com.aliyuncs.green.model.v20180509.TextScanRequest;
import com.aliyuncs.green.model.v20180509.VideoAsyncScanRequest;
import com.aliyuncs.green.model.v20180509.VideoAsyncScanResultsRequest;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
@Component
public class ContentAuditUtil {
	@Value("${aliyun.AccessKeyID}")
	private String accessKeyId;
	@Value("${aliyun.AccessKeySecret}")
	private String accessKeySecret;
	@Value("${aliyun.GreenUrl}")
	private String greenUrl;
	@Value("${aliyun.RegionId}")
	private String regionId;
	@Value("${aliyun.videoCallback}")
	private String videoCallback;
	

	public JSONObject auditImage(String dataId,String url){
		 try {
			IClientProfile profile = DefaultProfile.getProfile(regionId,accessKeyId,accessKeySecret);
			DefaultProfile.addEndpoint(regionId,regionId,"Green",greenUrl);
			IAcsClient client = new DefaultAcsClient(profile);
			
			ImageSyncScanRequest imageSyncScanRequest = new ImageSyncScanRequest();
	        imageSyncScanRequest.setAcceptFormat(FormatType.JSON); // 指定api返回格式
	        imageSyncScanRequest.setHttpContentType(FormatType.JSON);
	        imageSyncScanRequest.setMethod(com.aliyuncs.http.MethodType.POST);//指定请求方法
	        imageSyncScanRequest.setEncoding("utf-8");
	        imageSyncScanRequest.setRegionId(regionId);
	        
	        List<Map<String, Object>> tasks = new ArrayList<Map<String, Object>>();
	        Map<String, Object> task = new LinkedHashMap<String,Object>();
	        task.put("dataId",dataId);
	        task.put("url",url);
	        tasks.add(task);
	        JSONObject data = new JSONObject();
	        data.put("scenes", Arrays.asList("porn"));
	        data.put("tasks", tasks);
	        imageSyncScanRequest.setHttpContent(data.toJSONString().getBytes("UTF-8"),"UTF-8", FormatType.JSON);
	        imageSyncScanRequest.setConnectTimeout(3000);
	        imageSyncScanRequest.setReadTimeout(6000);

            HttpResponse httpResponse = client.doAction(imageSyncScanRequest);
            if (httpResponse.isSuccess()) {
                JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), "UTF-8"));
                System.out.println(JSON.toJSONString(scrResponse, true));
                if (200 == scrResponse.getInteger("code")) {
                    JSONArray taskResults = scrResponse.getJSONArray("data");
                    for (Object taskResult : taskResults) {
                        JSONArray sceneResults = ((JSONObject)taskResult).getJSONArray("results");
                        for (Object sceneResult : sceneResults) {
                            return (JSONObject)sceneResult;
                        }
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (ServerException e) {
            e.printStackTrace();
            return null;
        } catch (ClientException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
		return null;
	}
	
	
	public JSONObject auditVideo(String dataId,String url){
		try {
			IClientProfile profile = DefaultProfile.getProfile(regionId,accessKeyId,accessKeySecret);
			DefaultProfile.addEndpoint(regionId,regionId,"Green",greenUrl);
			IAcsClient client = new DefaultAcsClient(profile);
		
			VideoAsyncScanRequest videoAsyncScanRequest = new VideoAsyncScanRequest();
			videoAsyncScanRequest.setAcceptFormat(FormatType.JSON); // 指定api返回格式
			videoAsyncScanRequest.setHttpContentType(FormatType.JSON);
			videoAsyncScanRequest.setMethod(com.aliyuncs.http.MethodType.POST); // 指定请求方法
			videoAsyncScanRequest.setEncoding("utf-8");
			videoAsyncScanRequest.setRegionId(regionId);
	        
	        List<Map<String, Object>> tasks = new ArrayList<Map<String, Object>>();
	        Map<String, Object> task = new LinkedHashMap<String, Object>();
	        task.put("dataId",dataId);
	        task.put("url",url);
	        task.put("interval",1);
	        task.put("maxFrames",15);
	        tasks.add(task);
	        JSONObject data = new JSONObject();
	        data.put("scenes", Arrays.asList("porn"));
	        data.put("audioScenes",Arrays.asList("antispam"));//语音反垃圾
	        data.put("callback",videoCallback);
	        data.put("seed","qqyunximao");
	        data.put("tasks", tasks);
	        videoAsyncScanRequest.setHttpContent(data.toJSONString().getBytes("UTF-8"),"UTF-8", FormatType.JSON);
	        /**
	         * 请务必设置超时时间
	         */
	        videoAsyncScanRequest.setConnectTimeout(3000);
	        videoAsyncScanRequest.setReadTimeout(6000);

            HttpResponse httpResponse = client.doAction(videoAsyncScanRequest);
            if (httpResponse.isSuccess()) {
                JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), "UTF-8"));
                System.out.println(JSON.toJSONString(scrResponse, true));
                if (200 == scrResponse.getInteger("code")) {
                    JSONArray taskResults = scrResponse.getJSONArray("data");
                    for (Object taskResult : taskResults) {
                    	return ((JSONObject)taskResult);
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (ServerException e) {
            e.printStackTrace();
            return null;
        } catch (ClientException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
		return null;
	}
	
	public JSONObject getVideoAuditRtn(String taskId){
		try {
			IClientProfile profile = DefaultProfile.getProfile(regionId,accessKeyId,accessKeySecret);
			DefaultProfile.addEndpoint(regionId,regionId,"Green",greenUrl);
	        IAcsClient client = new DefaultAcsClient(profile);
	
	        VideoAsyncScanResultsRequest videoAsyncScanResultsRequest = new VideoAsyncScanResultsRequest();
	        videoAsyncScanResultsRequest.setAcceptFormat(FormatType.JSON);
	
	        List<String> taskList = new ArrayList<String>();
	        // 这里添加要查询的taskId，提交任务的时候需要自行保存taskId
	        taskList.add(taskId);
	
	        videoAsyncScanResultsRequest.setHttpContent(JSON.toJSONString(taskList).getBytes("UTF-8"), "UTF-8", FormatType.JSON);
	        /**
	         * 请务必设置超时时间
	         */
	        videoAsyncScanResultsRequest.setConnectTimeout(3000);
	        videoAsyncScanResultsRequest.setReadTimeout(6000);
	        try {
	            HttpResponse httpResponse = client.doAction(videoAsyncScanResultsRequest);
	            if(httpResponse.isSuccess()){
	                JSONObject jsonObject = JSON.parseObject(new String(httpResponse.getHttpContent(), "UTF-8"));
	                System.out.println(JSON.toJSONString(jsonObject, true));
	                return jsonObject;
	            }else{
	                return null;
	            }
	        } catch (ServerException e) {
	            e.printStackTrace();
	            return null;
	        } catch (ClientException e) {
	            e.printStackTrace();
	            return null;
	        }
		}catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	public boolean auditText(String content){
		try {
			if(StringUtils.isBlank(content)) {
				return true;
			}
			IClientProfile profile = DefaultProfile.getProfile(regionId,accessKeyId,accessKeySecret);
			DefaultProfile.addEndpoint(regionId,regionId,"Green",greenUrl);
	        IAcsClient client = new DefaultAcsClient(profile);
	
	        TextScanRequest textScanRequest = new TextScanRequest();
	        textScanRequest.setAcceptFormat(FormatType.JSON); // 指定api返回格式
	        textScanRequest.setHttpContentType(FormatType.JSON);
	        textScanRequest.setMethod(com.aliyuncs.http.MethodType.POST); // 指定请求方法
	        textScanRequest.setEncoding("UTF-8");
	        textScanRequest.setRegionId("cn-shanghai");
	
	        List<Map<String, Object>> tasks = new ArrayList<Map<String, Object>>();
	        Map<String, Object> task = new LinkedHashMap<String, Object>();
	        task.put("dataId",UUID.randomUUID().toString());
	        task.put("content",content);
	        tasks.add(task);
	        JSONObject data = new JSONObject();
	        data.put("scenes", Arrays.asList("antispam"));
	        data.put("tasks", tasks);
	        textScanRequest.setHttpContent(data.toJSONString().getBytes("UTF-8"), "UTF-8", FormatType.JSON);
	        // 请务必设置超时时间
	        textScanRequest.setConnectTimeout(3000);
	        textScanRequest.setReadTimeout(6000);
	        
	        HttpResponse httpResponse = client.doAction(textScanRequest);
	        if(httpResponse.isSuccess()){
                JSONObject scrResponse = JSON.parseObject(new String(httpResponse.getHttpContent(), "UTF-8"));
                System.out.println(JSON.toJSONString(scrResponse, true));
                if (200 == scrResponse.getInteger("code")) {
                    JSONArray taskResults = scrResponse.getJSONArray("data");
                    for (Object taskResult : taskResults) {
                        if(200 == ((JSONObject)taskResult).getInteger("code")){
                            JSONArray sceneResults = ((JSONObject)taskResult).getJSONArray("results");
                            for (Object sceneResult : sceneResults) {
                                String scene = ((JSONObject)sceneResult).getString("scene");
                                String suggestion = ((JSONObject)sceneResult).getString("suggestion");
                                if("pass".equals(suggestion)) {
                                	return true;
                                }else {
                                	return false;
                                }
                            }
                        }else{
                        	return false;
                        }
                    }
                } else {
                	return false;
                }
            }else{
                System.out.println("response not success. status:" + httpResponse.getStatus());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
		return false;
	}
}
