package com.petsfamily.yunximao.wechatService.controller.applet.user;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.petsfamily.yunximao.common.model.BaseController;
import com.petsfamily.yunximao.common.model.ResponseEntity;
import com.petsfamily.yunximao.wechatService.service.applet.AppletInterfaseService;

@RestController
@RequestMapping("/applet")
public class AppletUserController extends BaseController{
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private AppletInterfaseService appletInterfaseService;
	
	@RequestMapping(value = "/createUser", method = {RequestMethod.POST })
	public ResponseEntity createUser(@RequestBody JSONObject dataJson) throws Exception {
		logger.debug(appletInterfaseService.getUserInfo(dataJson).toJSONString());
		return ResponseEntity.buildSuccessful();
	}
}
