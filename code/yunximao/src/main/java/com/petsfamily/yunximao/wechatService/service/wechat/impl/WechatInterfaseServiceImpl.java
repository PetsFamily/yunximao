package com.petsfamily.yunximao.wechatService.service.wechat.impl;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.petsfamily.yunximao.common.util.http.HttpClient;
import com.petsfamily.yunximao.wechatService.common.constant.WechatConstant;
import com.petsfamily.yunximao.wechatService.service.wechat.WechatInterfaseService;
@Service
public class WechatInterfaseServiceImpl implements WechatInterfaseService{
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public JSONObject getAccessToken() throws ClientProtocolException, IOException {
		String url = WechatConstant.ROOT+
				"/cgi-bin/token?grant_type=client_credential"
				+ "&appid="+WechatConstant.APPID
				+ "&secret="+WechatConstant.APPSECRET;
		
		String response = HttpClient.get(url);
		return JSONObject.parseObject(response);
	}

	@Override
	public JSONObject getUserInfo(String openid, String unionid) throws ClientProtocolException, IOException{
		String url = WechatConstant.ROOT+
				"/cgi-bin/user/info"
				+ "?access_token="+WechatConstant.ACCESS_TOKEN
				+ "&openid="+openid
				+ "&lang=zh_CN";
		String response = HttpClient.get(url);
		return JSONObject.parseObject(response);
	}

}
