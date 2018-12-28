package com.petsfamily.yunximao.wechatService.service.wechat.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.petsfamily.yunximao.common.util.XmlUtil;
import com.petsfamily.yunximao.wechatService.common.model.WeChatBaseMessage;
import com.petsfamily.yunximao.wechatService.common.model.WeChatResult;
import com.petsfamily.yunximao.wechatService.service.wechat.CodeHandleService;
import com.petsfamily.yunximao.wechatService.service.wechat.MessageHandleService;
@Service
public class MessageHandleServiceImpl implements MessageHandleService {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private CodeHandleService codeHandleService;
	/*
     * 对来自微信的消息作出响应(包含消息和事件)
     * @param inputStream
     * @return
     * @throws Exception
     */
    @Override
    public String handleMessage(Map<String, String> params) throws Exception {
        logger.debug("开始处理【message】信息");
        String result = null;
        if (params != null && params.size() > 0) {
            WeChatBaseMessage msgInfo = new WeChatBaseMessage();
            String createTime = params.get("CreateTime");
            String msgId = params.get("MsgId");
            msgInfo.setCreateTime((createTime != null && !"".equals(createTime)) ? Integer.parseInt(createTime) : 0);
            msgInfo.setFromUserName(params.get("FromUserName"));
            msgInfo.setMsgId((msgId != null && !"".equals(msgId)) ? Long.parseLong(msgId) : 0);
            msgInfo.setToUserName(params.get("ToUserName"));
            WeChatResult resp = codeHandleService.handleCode(params, msgInfo);
            if (null == resp) {   
                return null;
            }else {
                result = XmlUtil.toXml(resp.getObject());
            }
        } else {
            result = "msg is wrong";

        }
        return result;
    }
}
