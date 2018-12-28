package com.petsfamily.yunximao.wechatService.service.wechat;

import java.util.Map;

import com.petsfamily.yunximao.wechatService.common.model.WeChatBaseMessage;
import com.petsfamily.yunximao.wechatService.common.model.WeChatResult;

public interface CodeHandleService {
	 public WeChatResult handleCode(Map<String, String> params, WeChatBaseMessage msgInfo);
}
