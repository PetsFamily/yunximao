package com.petsfamily.yunximao.wechatService.task;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.petsfamily.yunximao.wechatService.common.constant.WechatConstant;
import com.petsfamily.yunximao.wechatService.service.wechat.WechatInterfaseService;

@Component
public class WeChatTask {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private WechatInterfaseService wechatInterfaseService;
	/**每7000秒刷新refreshAccessToken
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws InterruptedException */
	@Scheduled(initialDelay = 5000,fixedDelay= 7000 * 1000)
	public void refreshAccessToken() throws ClientProtocolException, IOException, InterruptedException {
		JSONObject accessToken = wechatInterfaseService.getAccessToken();
		if(StringUtils.isNotBlank(accessToken.getString("access_token"))) {
			WechatConstant.ACCESS_TOKEN = accessToken.getString("access_token");
			logger.debug("微信 access_token 获取成功"+accessToken.toJSONString());
			return;
		}else {
			logger.error("微信 access_token 获取失败"+accessToken.toJSONString());
			Thread.currentThread().sleep(2000);
			refreshAccessToken();
		}	
	}
}
