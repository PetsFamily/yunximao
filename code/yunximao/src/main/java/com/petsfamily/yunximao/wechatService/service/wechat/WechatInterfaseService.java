package com.petsfamily.yunximao.wechatService.service.wechat;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSONObject;

public interface WechatInterfaseService {
	public JSONObject getAccessToken() throws ClientProtocolException, IOException;
	public JSONObject getUserInfo(String openid,String unionid) throws ClientProtocolException, IOException;
}
