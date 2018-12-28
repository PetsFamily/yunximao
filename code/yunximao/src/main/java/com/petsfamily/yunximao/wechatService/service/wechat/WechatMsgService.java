package com.petsfamily.yunximao.wechatService.service.wechat;

import java.util.Map;

import com.petsfamily.yunximao.wechatService.common.model.WeChatBaseMessage;
import com.petsfamily.yunximao.wechatService.common.model.WeChatResult;

public interface WechatMsgService {
	public WeChatResult textMsgInfo(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult imageMsgInfo(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult linkMsgInfo(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult locationMsgInfo(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult voiceMsgInfo(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult shortVideo(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult videoMsgInfo(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult subscribe(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult unsubscribe(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult scan(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult eventLocation(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult eventClick(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult eventView(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult kfCreateSession(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult kfCloseSession(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult kfSwitchSession(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult eventDefaultReply(Map<String, String> params, WeChatBaseMessage msgInfo);
	public WeChatResult defaultMsgInfo(Map<String, String> params, WeChatBaseMessage msgInfo);
}
