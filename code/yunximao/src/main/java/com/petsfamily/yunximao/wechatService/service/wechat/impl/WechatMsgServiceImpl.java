package com.petsfamily.yunximao.wechatService.service.wechat.impl;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.petsfamily.yunximao.common.util.DateTimeUtil;
import com.petsfamily.yunximao.wechatService.common.model.TextMessage;
import com.petsfamily.yunximao.wechatService.common.model.WeChatBaseMessage;
import com.petsfamily.yunximao.wechatService.common.model.WeChatResult;
import com.petsfamily.yunximao.wechatService.service.wechat.WechatInterfaseService;
import com.petsfamily.yunximao.wechatService.service.wechat.WechatMsgService;
@Service
public class WechatMsgServiceImpl implements WechatMsgService {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private WechatInterfaseService wechatInterfaseService;
	
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
    	 String openId = msgInfo.getFromUserName();
         WeChatResult result = new WeChatResult();
         if(StringUtils.isNotBlank(openId)) {
        	 logger.debug("订阅用户openId:"+openId);
        	 try {
        		//JSONObject user = wechatInterfaseService.getUserInfo(openId);
        		//logger.debug(user.toJSONString());
        		TextMessage text = new TextMessage();
  		        text.setContent("欢迎光临,精彩尽请期待!");// 自动回复
  		        text.setCreateTime(DateTimeUtil.currentTime());
  		        text.setToUserName(msgInfo.getFromUserName());
  		        text.setFromUserName(msgInfo.getToUserName());
  		        text.setMsgId(msgInfo.getMsgId());
  		        text.setMsgType("text");
  		        result.setObject(text);
        	 }catch (Exception e) {
				e.printStackTrace();
				logger.debug("获取用户信息异常:"+openId);
			}
         }else {
        	 logger.debug("订阅用户openId获取失败");
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
