package com.petsfamily.yunximao.wechatService.service.wechat;

import java.util.Map;

public interface MessageHandleService {
	public String handleMessage(Map<String, String> params) throws Exception;
}
