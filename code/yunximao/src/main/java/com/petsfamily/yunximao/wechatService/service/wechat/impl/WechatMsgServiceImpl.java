package com.petsfamily.yunximao.wechatService.service.wechat.impl;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.petsfamily.yunximao.common.util.DateTimeUtil;
import com.petsfamily.yunximao.wechatService.common.model.TextMessage;
import com.petsfamily.yunximao.wechatService.common.model.WeChatBaseMessage;
import com.petsfamily.yunximao.wechatService.common.model.WeChatResult;
import com.petsfamily.yunximao.wechatService.controller.wechat.WechatController;
import com.petsfamily.yunximao.wechatService.service.wechat.WechatMsgService;
@Service
public class WechatMsgServiceImpl implements WechatMsgService {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult textMsgInfo(Map<String, String> params, WeChatBaseMessage msgInfo) {
        String content = params.get("Content").trim();
        logger.debug("文本消息:"+content);
        WeChatResult result = new WeChatResult();
        switch (content) {
			default:
		        TextMessage text = new TextMessage();
		        text.setContent("精彩才刚刚开始");// 自动回复
		        text.setCreateTime(DateTimeUtil.currentTime());
		        text.setToUserName(msgInfo.getFromUserName());
		        text.setFromUserName(msgInfo.getToUserName());
		        text.setMsgId(msgInfo.getMsgId());
		        text.setMsgType("text");
		        result.setObject(text);
				break;
		}
        return result;
        
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult imageMsgInfo(Map<String, String> params, WeChatBaseMessage msgInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult linkMsgInfo(Map<String, String> params, WeChatBaseMessage msgInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult locationMsgInfo(Map<String, String> params, WeChatBaseMessage msgInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult voiceMsgInfo(Map<String, String> params, WeChatBaseMessage msgInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult shortVideo(Map<String, String> params, WeChatBaseMessage msgInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult videoMsgInfo(Map<String, String> params, WeChatBaseMessage msgInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult subscribe(Map<String, String> params, WeChatBaseMessage msgInfo) {
        logger.debug("开始调用关注回复服务");
        return null;
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult unsubscribe(Map<String, String> params, WeChatBaseMessage msgInfo) {

        return null;
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult scan(Map<String, String> params, WeChatBaseMessage msgInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult eventLocation(Map<String, String> params, WeChatBaseMessage msgInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult eventClick(Map<String, String> params, WeChatBaseMessage msgInfo) {
        return null;
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult eventView(Map<String, String> params, WeChatBaseMessage msgInfo) {
        logger.info("view事件，人工客服");
        return null;

    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult kfCreateSession(Map<String, String> params, WeChatBaseMessage msgInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult kfCloseSession(Map<String, String> params, WeChatBaseMessage msgInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     * 
     * @return
     */
    @Override
    public WeChatResult kfSwitchSession(Map<String, String> params, WeChatBaseMessage msgInfo) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     */
    @Override
    public WeChatResult eventDefaultReply(Map<String, String> params, WeChatBaseMessage msgInfo) {
        // TODO Auto-generated method stub
    	return null;
    }

    /*
     * TODO
     * 
     * @param params
     * 
     * @param msgInfo
     */
    @Override
    public WeChatResult defaultMsgInfo(Map<String, String> params, WeChatBaseMessage msgInfo) {
        // TODO Auto-generated method stub
    	return null;
    }
	
}
