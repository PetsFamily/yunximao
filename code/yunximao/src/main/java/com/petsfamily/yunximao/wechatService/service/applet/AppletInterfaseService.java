package com.petsfamily.yunximao.wechatService.service.applet;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSONObject;

public interface AppletInterfaseService {
	public JSONObject getSessionKey(String code) throws ClientProtocolException, IOException;
	public JSONObject getUserInfo(JSONObject dataJson) throws ClientProtocolException, IOException;
}
