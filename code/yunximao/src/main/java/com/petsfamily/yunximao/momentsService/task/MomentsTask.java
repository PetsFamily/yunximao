package com.petsfamily.yunximao.momentsService.task;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.petsfamily.yunximao.momentsService.service.MomentsService;
@Component
public class MomentsTask {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private MomentsService momentsService;
	/**每7000秒刷新refreshAccessToken
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @throws InterruptedException */
	//@Scheduled(initialDelay = 5000,fixedDelay= 60 * 1000)
	public void refreshAccessToken() throws ClientProtocolException, IOException, InterruptedException {
		momentsService.reAuditVideo(null);
	}
}
