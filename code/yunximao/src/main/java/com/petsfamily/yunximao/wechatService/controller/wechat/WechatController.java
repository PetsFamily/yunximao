package com.petsfamily.yunximao.wechatService.controller.wechat;

import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petsfamily.yunximao.common.model.BaseController;
import com.petsfamily.yunximao.common.util.XmlUtil;
import com.petsfamily.yunximao.wechatService.common.util.SignatureUtil;
import com.petsfamily.yunximao.wechatService.service.wechat.MessageHandleService;

@RestController
@RequestMapping("/wechat")
public class WechatController extends BaseController{
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private MessageHandleService messageHandleService;
	
	@RequestMapping(value = "/handler", method = { RequestMethod.GET, RequestMethod.POST })
	public void processPost() throws Exception {
	  	this.getRequest().setCharacterEncoding("UTF-8");
        this.getResponse().setCharacterEncoding("UTF-8");
        boolean ispost = Objects.equals("POST", this.getRequest().getMethod().toUpperCase());
        if(ispost) {
        	 logger.debug("接收成功，正在处理逻辑");
        	 InputStream inputStream = this.getRequest().getInputStream();
             Map<String, String> params = XmlUtil.doXMLParse(inputStream);
             String respXml = messageHandleService.handleMessage(params);
             if (StringUtils.isNoneBlank(respXml)) {
                 // 输出流
                 this.getResponse().getWriter().write(respXml);
             }
        }else {
        	 // 签名
            String signature = this.getRequest().getParameter("signature");
            // 时间戳
            String timestamp = this.getRequest().getParameter("timestamp");
            // 随机数
            String nonce = this.getRequest().getParameter("nonce");
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
            if (SignatureUtil.checkSignature(signature, timestamp, nonce)) {
                // 随机字符串
                String echostr = this.getRequest().getParameter("echostr");
                logger.debug("接入成功，echostr {}", echostr);
                this.getResponse().getWriter().write(echostr);
            }
        }
    }
}

